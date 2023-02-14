package cmc.com.demo.appconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class Common {
    @Autowired
//    @Qualifier("dataSource")
    DataSource dataSource;
    @Autowired
    private ApplicationContext context;

    public List<?>  bindingModuleView(Object obj, String sql)  throws Exception {
       return bindingModuleView(obj,sql,"dataSource");
    }
    public List<?> bindingModuleView(Object obj, String sql,String datasource) throws SQLException, InstantiationException, IllegalAccessException {
        List list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Field> lsFields = new ArrayList<>();
        DataSource dataSource1 = (DataSource) context.getBean(datasource);
        connection = dataSource1.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        if (resultSet != null) {
            ResultSetMetaData rsMeta = resultSet.getMetaData();
            Class<?> responseClass = obj.getClass();
            for (int i = 1; i <= rsMeta.getColumnCount(); i++) {
                for (Field field : responseClass.getDeclaredFields()) {
                    if (field.getName()
                            .equalsIgnoreCase(rsMeta.getColumnLabel(i))) {
                        lsFields.add(field);
                    }
                }
            }

            while (resultSet.next()) {
                obj = responseClass.newInstance();
                for (Field field : lsFields) {
//                    for (Field fieldType : responseClass.getDeclaredFields()) {
//                        try {
//                            if (field.getType().getSimpleName().equalsIgnoreCase(fieldType.getType().getSimpleName())) {
//                                field.set(obj, resultSet.getString(field.getName()));
//                            }
//                        }catch (Exception e){
//                            System.out.println(e);
//                        }
//                    }

                    if (field.getType().getSimpleName().equalsIgnoreCase("String")) {
                        field.set(obj, resultSet.getString(field.getName()));
                    } else if (field.getType().getSimpleName()
                            .equalsIgnoreCase("Long")) {
                        field.set(obj, resultSet.getLong(field.getName()));
                    } else if (field.getType().getSimpleName()
                            .equalsIgnoreCase("Integer")) {
                        field.set(obj, resultSet.getInt(field.getName()));
                    } else if (field.getType().getSimpleName()
                            .equalsIgnoreCase("double")) {
                        field.set(obj, resultSet.getDouble(field.getName()));
                    } else if (field.getType().getSimpleName()
                            .equalsIgnoreCase("Date")) {
                        field.set(obj, resultSet.getTimestamp(field.getName()));
                    }
                }
                list.add(obj);
            }
        }
        return list;
    }
}
