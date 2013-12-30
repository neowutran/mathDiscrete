package dessin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

public class F4kSolution extends AbstractSolution {

    private static Polygon       container;
    private static List<Polygon> polygons          = new ArrayList();
    private static List<Polygon> newlyAddedPolygon = new ArrayList();
    private static final long    serialVersionUID  = 1L;

    public F4kSolution(final int profondeur) {
        super(profondeur);

        // TODO Auto-generated constructor stub
    }

    public boolean collision(final Polygon p1, final Polygon p2) {

        Area area = new Area(p1);
        area.intersect(new Area(p2));
        return !area.isEmpty();

    }

    public boolean contain(final int x, final int y) {

        if (F4kSolution.container.contains(x, y)) {
            return true;
        }
        return false;
    }

    @Override
    public void drawSolutionk(final Graphics drawingArea, final double... arg) {
        // TODO Auto-generated method stub

        Graphics2D g2d = (Graphics2D) drawingArea;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        double x = arg[0];
        double y = arg[1];
        double size = arg[2];

        // pi * r²; somme{i=0}{k} pi * (r/(1+i*2))²

        g2d.setColor(Color.black);

        if (F4kSolution.container == null) {
            int xContainer = 300;
            int yContainer = 300;
            int[] arrayX = new int[3];
            int[] arrayY = new int[3];
            List<int[]> points = new ArrayList();

            for (int i = 0; i < 3; i++) {
                arrayX[i] = xContainer
                        + (int) Math.round(130 * Math
                                .cos((Math.PI / 3) * i * 2));
                arrayY[i] = yContainer
                        + (int) Math.round(130 * Math
                                .sin((Math.PI / 3) * i * 2));

            }

            F4kSolution.container = new Polygon(arrayX, arrayY, 3);
            g2d.drawPolygon(F4kSolution.container);
        }

        List<int[]> points = this.drawTriangle(g2d, size, x, y);

        if (null == points) {
            return;
        }

        if (arg[3] != 1) {

        }

    }

    private List<int[]> drawTriangle(final Graphics draw, final double size,
            final double x, final double y) {

        int[] arrayX = new int[3];
        int[] arrayY = new int[3];
        List<int[]> points = new ArrayList();

        for (int i = 0; i < 3; i++) {
            arrayX[i] = (int) (x + (size * Math.cos(Math.toRadians(120 * i))));
            arrayY[i] = (int) (y + (size * Math.sin(Math.toRadians(120 * i))));

            if (!this.contain(arrayX[i], arrayY[i])) {
                return null;
            }

        }

        points.add(arrayX);
        points.add(arrayY);

        Polygon p = new Polygon(arrayX, arrayY, 3);

        for (Polygon p1 : F4kSolution.polygons) {

            if (this.collision(p1, p)) {
                return null;
            }

        }

        F4kSolution.newlyAddedPolygon.add(p);
        F4kSolution.polygons.add(p);
        draw.drawPolygon(arrayX, arrayY, 3);

        return points;
    }
}
