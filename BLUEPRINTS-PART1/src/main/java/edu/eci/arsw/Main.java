package edu.eci.arsw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws BlueprintNotFoundException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bps = ac.getBean(BlueprintsServices.class);
        /*
        Blueprint bp = new Blueprint("test", "test2");
        Blueprint bp2 = new Blueprint("test", "test.3");
        bps.addNewBlueprint(bp);
        bps.addNewBlueprint(bp2);
        System.out.println("Agregado");
        System.out.println(bps.getBlueprint("test", "test2"));
        System.out.println(bps.getBlueprintsByAuthor("test"));
        Blueprint bp3ListPo = new Blueprint( "tes2", "test2", new Point[]{new Point(140, 140),new Point(115, 115)} ) ; 
        Blueprint bp3 = new Blueprint("tes2","test2");
        bps.addNewBlueprint(bp3ListPo);
        //bps.addNewBlueprint(bp3);
        System.out.println(bps.getBlueprintsByAuthor("tes2"));*/
        /*Blueprint bp3ListPo3 = new Blueprint( "tes3", "testssf2", new Point[]{new Point(140, 140),
            new Point(115, 115)
            ,new Point(115, 115)
            ,new Point(115, 115)
            ,new Point(115, 115)
            ,new Point(115, 115)
            ,new Point(115, 115)
        } ) ; 
        bps.addNewBlueprint(bp3ListPo2);
        bps.addNewBlueprint(bp3ListPo3);*/
        Blueprint bpForSubsamplingFiltering = new Blueprint( "tes3", "test2", new Point[]{new Point(140, 140),
            new Point(115, 115)
            ,new Point(116, 116)
            ,new Point(117, 117)
            ,new Point(118, 118)
            ,new Point(119, 119)
            ,new Point(120, 120)
        } ) ;
        bps.addNewBlueprint(bpForSubsamplingFiltering);
        System.out.println(bps.getBlueprint(bpForSubsamplingFiltering.getAuthor(), bpForSubsamplingFiltering.getName()));


    }
}