package cmc.com.demo.controller;

import cmc.com.demo.appconfig.Common;
import cmc.com.demo.entity.Response;
import cmc.com.demo.entity.bar.Bar;
import cmc.com.demo.entity.foo.Foo;


import cmc.com.demo.repository.bar.BarRepository;
import cmc.com.demo.repository.foo.FooRepository;
//import cmc.com.demo.repository.foo.TotalRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.metamodel.Type;
import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FooBarController {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    @Qualifier("dataSource")
    DataSource dataSource;
    private final FooRepository fooRepo;
    //    private final BarRepository barRepo;
    private final BarRepository barfoorepo;
//    private final INtkRepository ntkrepo;
//private final TotalRepository iTotalRepository;


    @Autowired
//    FooBarController(FooRepository fooRepo, BarRepository barRepo,BarFRepository barfoorepo, INtkRepository ntk) {
    FooBarController(FooRepository fooRepo, BarRepository barfoorepo) {
        this.fooRepo = fooRepo;
//        this.barRepo = barRepo;
        this.barfoorepo = barfoorepo;
//        this.iTotalRepository = iTotalRepository;
//        this.ntkrepo = ntk;
    }

    @RequestMapping("/foobar/{id}")
    public ResponseEntity<?> fooBar(@PathVariable("id") Long id) throws NoSuchMethodException, SQLException, InstantiationException, IllegalAccessException {
        Foo foo = fooRepo.findById(id).get();
//        Bar bar = barRepo.findById(id).get();
       final Bar barf = barfoorepo.getById(id);
       List<Bar> bars = new ArrayList<>();
       bars.add(barf);
        Foo newfoo = new Foo();
        newfoo.setFoo("foo4");
        newfoo.setBar(bars);
        fooRepo.save(newfoo);
//        Ntk ntk = ntkrepo.findById(id).get();
//        List<Response> totals = (List<Response>) iTotalRepository.findOther();
//        List<Response> responses = (List<Response>) entityManager.createNativeQuery("select b.ID as id,b.BAR as total, f.FOO as foo, f.FOO as bar from BAR as b join FOO as f on b.ID = f.ID").getResultList();
        Response response = new Response();
        List list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Field> lsFields = new ArrayList<>();
        connection = dataSource.getConnection();
//        List<Object[]> objects = entityManager.createNativeQuery("select b.ID as id,b.BAR as total from BAR as b").getResultList();
        preparedStatement = connection.prepareStatement("select ID as id, foo as total, foo as foo from foo ");
            resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                ResultSetMetaData rsMeta = resultSet.getMetaData();
                Class<Response> responseClass = Response.class;
                for (int i = 1; i <= rsMeta.getColumnCount(); i++) {
                    for (Field field : responseClass.getDeclaredFields()) {
                        if (field.getName()
                                .equalsIgnoreCase(rsMeta.getColumnLabel(i))) {
                            lsFields.add(field);
                        }
                    }
                }

            while (resultSet.next()) {
                    response = responseClass.newInstance();
                    for (Field field : lsFields) {
                        if (field.getType().getSimpleName().equalsIgnoreCase("String")) {
                            field.set(response, resultSet.getString(field.getName()));
                        } else if (field.getType().getSimpleName()
                                .equalsIgnoreCase("Long")) {
                            field.set(response, resultSet.getLong(field.getName()));
                        } else if (field.getType().getSimpleName()
                                .equalsIgnoreCase("Integer")) {
                            field.set(response, resultSet.getInt(field.getName()));
                        } else if (field.getType().getSimpleName()
                                .equalsIgnoreCase("double")) {
                            field.set(response, resultSet.getDouble(field.getName()));
                        } else if (field.getType().getSimpleName()
                                .equalsIgnoreCase("Date")) {
                            field.set(response, resultSet.getTimestamp(field.getName()));
                        }
                    }
            list.add(response);
                }
        }

//        return foo.getFoo() + " " + bar.getBar()+ " " + barf.getBar()+ " " + ntk.getCode();
//        return foo.getFoo() + " " + barf.getBar()+ " "+totals.size();
        return new ResponseEntity<>(foo, HttpStatus.OK);
    }

    @Autowired
    Common common;

    @RequestMapping("/test")
    public ResponseEntity<?> testBinding() throws Exception {
//        List<Response> list = (List<Response>) common.bindingModuleView(new Response(),"select ID as id, bar as total, bar as foo from bar");
        List<String> name = new ArrayList<>();
        name.add("foo1");
        name.add("foo2");
        name.add("foo4");
        List<Foo> list = (List<Foo>) fooRepo.findByName(name);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
