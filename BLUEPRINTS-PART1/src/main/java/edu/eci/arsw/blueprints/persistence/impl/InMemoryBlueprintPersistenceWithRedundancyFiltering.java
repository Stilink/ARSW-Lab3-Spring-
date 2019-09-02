/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;

import java.awt.SystemTray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

/**
 *
 * @author hcadavid
 */
@Component
public class InMemoryBlueprintPersistenceWithRedundancyFiltering implements BlueprintsPersistence {

    private final Map<Tuple<String, String>, Blueprint> blueprints = new HashMap<>();

    public InMemoryBlueprintPersistenceWithRedundancyFiltering() {
        // load stub data
        Point[] pts = new Point[] { new Point(140, 140), new Point(115, 115) };
        Blueprint bp = new Blueprint("_authorname_", "_bpname_ ", pts);
        blueprints.put(new Tuple<>(bp.getAuthor(), bp.getName()), bp);

    }

    @Override
    public void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        if (blueprints.containsKey(new Tuple<>(bp.getAuthor(), bp.getName()))) {
            throw new BlueprintPersistenceException("The given blueprint already exists: " + bp);
        } else {
            blueprints.put(new Tuple<>(bp.getAuthor(), bp.getName()), bp);
        }
    }

    public Blueprint filterBluePrint(Blueprint bp) {

        List<Point> points = bp.getPoints();
        List<Point> newPoints = new ArrayList<Point>();
        for (int i = 0; i < points.size(); i++) {
            int pos = i + 1;
            newPoints.add(points.get(i));
            while (pos < points.size() && points.get(i).equals(points.get(pos))) {
                pos++;
            }
            i = pos;
        }
        Point[] np = new Point[newPoints.size()];
        for(int i = 0; i < newPoints.size(); i++) np[i] = newPoints.get(i);
        Blueprint newBlueprint = new Blueprint(bp.getAuthor(), bp.getName(), np);
        return newBlueprint;
    }

    @Override
    public Blueprint getBlueprint(String author, String bprintname) throws BlueprintNotFoundException {
        Blueprint bp = blueprints.get(new Tuple<>(author, bprintname));

        return filterBluePrint(bp);
    }

    @Override
    public Set<Blueprint> getBluerintsByAuthor(String author) throws BlueprintNotFoundException {
        Set<Blueprint> bluePrints = new HashSet<Blueprint>();
        for (Tuple t : blueprints.keySet()) {
            // System.out.println(t.getElem1().toString() + " " + author);
            if (t.getElem1().toString().equals(author)) {
                Blueprint bp = filterBluePrint(blueprints.get(t));
                bluePrints.add(bp);
            }
        }
        return bluePrints;
    }

}
