package edu.eci.arsw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws BlueprintNotFoundException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bps = ac.getBean(BlueprintsServices.class);
        Blueprint bp = new Blueprint("test", "test2");
        bps.addNewBlueprint(bp);
        System.out.println("Agregado");
        System.out.println(bps.getBlueprint("test", "test2"));
    }
}