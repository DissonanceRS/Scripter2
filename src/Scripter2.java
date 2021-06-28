import org.osbot.rs07.api.Widgets;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.model.Item;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.ui.RS2Widget;
import org.osbot.rs07.api.util.LocalPathFinder;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.event.WalkingEvent;
import org.osbot.rs07.event.WebWalkEvent;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

@ScriptManifest(author = "Dissonance", info = "Scripter2", logo = "", name = "Scripter2", version = 1)
public class Scripter2 extends Script {
    @Override
    public int onLoop() throws InterruptedException {

        //question1();
        //question2();
        //question3();
        //question4();


        return 0;
    }

    @Override
    public void onPaint(Graphics2D g) {
        //question5(g);
    }

    public void question1() {
        LocalPathFinder localPathFinder = new LocalPathFinder(getBot());
        Position playerPos10S = new Position(myPosition().getX(), myPosition().getY() - 10, myPosition().getZ());
        LinkedList<Position> newPath = localPathFinder.findPath(playerPos10S);

        WalkingEvent walking10S = new WalkingEvent();
        walking10S.setOperateCamera(false);
        walking10S.setPath(newPath);
        execute(walking10S);
    }


    public void question2() {
        RS2Widget close = getWidgets().getWidgetContainingAction("Close");
        if (close != null) {
            log("Root ID: " + close.getRootId());
            log("Child ID +: " + close.getSecondLevelId());
            log("Child ID ++: " + close.getThirdLevelId());
        }
    }


    public void question3() {
        if (getInventory().getAmount("Logs") == 28) {
            Item fifthItem = getInventory().getItemInSlot(4);
            if (fifthItem != null && fifthItem.getName().equals("Logs")) {
                getMouse().click(getInventory().getMouseDestination(4), true);
                getMouse().move(getMouse().getPosition().x, getMouse().getPosition().y + 40);
                getMouse().click(false);
            }
        }
    }


    public void question4() {
        Area bank1 = new Area(3218, 3226, 3219, 3225);
        Area bank2 = new Area(3208, 3202, 3209, 3203);
        Area bank3 = new Area(3213, 3219, 3214, 3218);

        Area[] bankAreas = new Area[] { bank1, bank2, bank3 };

        WebWalkEvent webWalkBank = new WebWalkEvent(bankAreas);
        webWalkBank.prefetchRequirements(this);
        if (webWalkBank.getDestination() != null) {
            log(webWalkBank.getDestination());
        }
    }


    public void question5(Graphics2D g) {
        g.setColor(Color.RED);
        NPC man = getNpcs().closest("Man");
        g.draw(man.getModel().getBoundingBox(man.getGridX(),man.getGridY(),man.getZ()));
    }
}
