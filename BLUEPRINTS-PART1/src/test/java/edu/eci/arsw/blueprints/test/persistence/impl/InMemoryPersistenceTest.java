/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */
public class InMemoryPersistenceTest {
    
    @Test
    public void saveNewAndLoadTest() throws BlueprintPersistenceException, BlueprintNotFoundException{
        InMemoryBlueprintPersistence ibpp=new InMemoryBlueprintPersistence();

        Point[] pts0=new Point[]{new Point(40, 40),new Point(15, 15)};
        Blueprint bp0=new Blueprint("mack", "mypaint",pts0);
        
        ibpp.saveBlueprint(bp0);
        
        Point[] pts=new Point[]{new Point(0, 0),new Point(10, 10)};
        Blueprint bp=new Blueprint("john", "thepaint",pts);
        
        ibpp.saveBlueprint(bp);
        
        assertNotNull("Loading a previously stored blueprint returned null.",ibpp.getBlueprint(bp.getAuthor(), bp.getName()));
        
        assertEquals("Loading a previously stored blueprint returned a different blueprint.",ibpp.getBlueprint(bp.getAuthor(), bp.getName()), bp);
        
    }


    @Test
    public void saveExistingBpTest() {
        InMemoryBlueprintPersistence ibpp=new InMemoryBlueprintPersistence();
        
        Point[] pts=new Point[]{new Point(0, 0),new Point(10, 10)};
        Blueprint bp=new Blueprint("john", "thepaint",pts);
        
        try {
            ibpp.saveBlueprint(bp);
        } catch (BlueprintPersistenceException ex) {
            fail("Blueprint persistence failed inserting the first blueprint.");
        }
        
        Point[] pts2=new Point[]{new Point(10, 10),new Point(20, 20)};
        Blueprint bp2=new Blueprint("john", "thepaint",pts2);

        try{
            ibpp.saveBlueprint(bp2);
            fail("An exception was expected after saving a second blueprint with the same name and autor");
        }
        catch (BlueprintPersistenceException ex){
            
        }
                
        
    }

    @Test

    public void redundancyFilterTestGetBluePrint() throws BlueprintPersistenceException, BlueprintNotFoundException {

        InMemoryBlueprintPersistence ibpp=new InMemoryBlueprintPersistence();

        Point[] points = new Point[] { new Point(140, 140)
            ,new Point(115, 115)
            ,new Point(115, 115)
            ,new Point(115, 115)
            ,new Point(115, 115)
            ,new Point(115, 115)
            ,new Point(115, 115)
            };
        Blueprint bp =new Blueprint("redundancyFilter", "thepaint", points);

        Point[] pointFilter = new Point[] { new Point(140, 140)
            ,new Point(115, 115)
            };
        Blueprint bpFilter =new Blueprint("redundancyFilter", "thepaint", points);

        ibpp.saveBlueprint(bp);

        
        assertEquals(ibpp.getBlueprint(bp.getAuthor(), bp.getName()), bpFilter);
    }

    public void redundancyFilterTestGetBluePrintByAuthor() throws BlueprintPersistenceException, BlueprintNotFoundException {

        InMemoryBlueprintPersistence ibpp=new InMemoryBlueprintPersistence();

        Point[] points1 = new Point[] { new Point(140, 140)
            ,new Point(115, 115)
            ,new Point(115, 115)
            ,new Point(115, 115)
            ,new Point(115, 115)
            ,new Point(115, 115)
            ,new Point(115, 115)
            };
        Blueprint bp1 =new Blueprint("redundancyFilter", "thepaint1", points1);
        
        ibpp.saveBlueprint(bp1);

        Point[] points2 = new Point[] { new Point(140, 140)
            ,new Point(115, 115)
            ,new Point(120, 120)
            ,new Point(120, 120)
            ,new Point(115, 115)
            ,new Point(115, 115)
            ,new Point(115, 115)
            };
        Blueprint bp2 =new Blueprint("redundancyFilter", "thepaint2", points2);
        
        ibpp.saveBlueprint(bp2);

        Point[] points3 = new Point[] { new Point(140, 140)
            ,new Point(140, 140)
            ,new Point(120, 120)
            ,new Point(115, 115)
            ,new Point(115, 115)
            ,new Point(130, 130)
            ,new Point(130, 130)
            };
        Blueprint bp3 =new Blueprint("redundancyFilter", "thepaint3", points3);
        
        ibpp.saveBlueprint(bp3);

        Point[] pointFilter1 = new Point[] { new Point(140, 140)
            ,new Point(115, 115)
            };
        Blueprint bpFilter1 =new Blueprint("redundancyFilter", "thepaint1", pointFilter1);

        Point[] pointFilter2 = new Point[] { new Point(140, 140)
            ,new Point(115, 115)
            ,new Point(120, 120)
            ,new Point(115, 115)
            };
        Blueprint bpFilter2 =new Blueprint("redundancyFilter", "thepaint2", pointFilter2);

        Point[] pointFilter3 = new Point[] { new Point(140, 140)
            ,new Point(120, 120)
            ,new Point(115, 115)
            ,new Point(130, 130)
            };
        Blueprint bpFilter3 =new Blueprint("redundancyFilter", "thepaint3", pointFilter3);
        
        Set setBpFilter = new HashSet<Blueprint>();

        setBpFilter.add(bpFilter1);
        setBpFilter.add(bpFilter2);
        setBpFilter.add(bpFilter3);
        
        
        
        //assertEquals(ibpp.getBlueprint(bp.getAuthor(), bp.getName()), bpFilter);
    }


    
}