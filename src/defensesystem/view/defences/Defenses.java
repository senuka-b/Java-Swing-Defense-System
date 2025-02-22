/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package defensesystem.view.defences;

import defensesystem.util.Observer;
import defensesystem.view.controller.MainControllerForm;
import javax.swing.JFrame;

/**
 *
 * @author senuka
 */
public enum Defenses {
    HELICOPTER("Helicopter Defense", HelicopterDefense.class),
    TANK("Tank Defense", TankDefense.class),
    SUBMARINE("Submarine Defense", SubmarineDefense.class);

    private final String displayName;
    private final Class<? extends Observer> frameClass; // a type that is a subclass of Observer or Observer itself.

    Defenses(String displayName, Class<? extends Observer> frameClass) {
        this.displayName = displayName;
        this.frameClass = frameClass;
    }

    public String getDisplayName() {
        return displayName;
    }
    
    public static String[] getAllDefenseDisplayNames() {
        String[] displayNames = new String[Defenses.values().length];
        
        for (int i = 0; i < displayNames.length; i++) {
            String displayName = Defenses.values()[i].getDisplayName();
            displayNames[i] = displayName;
        }
        
        return displayNames;
    }

    public Observer createInstance(String title, MainControllerForm mainController) {
        try {
            return frameClass.getDeclaredConstructor(String.class, MainControllerForm.class).newInstance(title, mainController);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create instance for: " + this.name());
        }
    }
}
