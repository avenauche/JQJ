package JQJ;

import java.util.*;

public class Hashes {

    private static HashMap JDOM = new HashMap();
    private static String variableName = "";
    private static String pseudoSelector;

    public Hashes(String selector) {

        if (selector.indexOf(":") == -1) {
            variableName = selector;
            createString(variableName);
        } else if (selector.indexOf(":") > 0) {

            variableName = selector.split(":")[0];
            pseudoSelector = selector.split(":")[1];

            if (pseudoSelector.equalsIgnoreCase("string")) {
                createString(variableName);
            } else {
                createObj(variableName, pseudoSelector);
            }

        } else {
            System.out.println("no variable name found");
        }

    }

    private Hashes createObj(String variableName, String className) {

        try {
            JDOM.put(variableName, Class.forName(className).newInstance());
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Hashes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
//            Logger.getLogger(Hashes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
//            Logger.getLogger(Hashes.class.getName()).log(Level.SEVERE, null, ex);
        }

        return this;
    }

    private void createString(String variableName) {
        Hashes.variableName = variableName;

        if (!JDOM.containsKey(Hashes.variableName)) {
            JDOM.put(Hashes.variableName, "");
        }
    }

    public Hashes setString(String strVal) {
        JDOM.put(Hashes.variableName, strVal);
        return this;
    }

    public Hashes setObj() {
//        JDOM.put(Hashes.variableName, val);
//        ((ArrayList) JDOM.get(Hashes.variableName)).add(val);
        System.out.println("setObj");
        Collections.addAll(((ArrayList) JDOM.get(Hashes.variableName)), 1,2,3);
        return this;
    }

    public String getString() {
        return JDOM.get(Hashes.variableName).toString();
    }

    public ArrayList getArrayList() {
        return (ArrayList) JDOM.get(Hashes.variableName);
    }

    public static Hashes $(String variableName) {
        return new Hashes(variableName);
    }

    public static void main(String[] args) {
//        $(":string").setString("avinash");

//        System.out.println("avinash : " + $("strVal").setString("Avinash"));
//        System.out.println("avenauche : " + $("strVal1:String").setString("Avenauche"));
//        System.out.println("avinash : " + $("strVal").getString());
//        System.out.println("avenauche : " + $("strVal1").getString());

//        String[] str = {"avinash", "avenauche"};
        $("aList:ArrayList");
//        $("aList:ArrayList").setObj();
//        System.out.println("arrayList : " + $("aList").getArrayList());


    }
//    @Override
//    public String toString() {
//        return JDOM.get(Hashes.variableName).toString();
//    }
}
