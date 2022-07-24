package nestedClasses;

public class OuterClass {

    String outerField = "Outer field"; // outerField is a field in OuterClass
    static String staticOuterField = "Static outer field"; // staticOuterField is a field in OuterClass

    class InnerClass { // InnerClass is a nested class in OuterClass
        void accessMembers() { // accessMembers is a method in InnerClass
            System.out.println(outerField); // outerField is a field in OuterClass
            System.out.println(staticOuterField); // staticOuterField is a field in OuterClass
        }
    }

    static class StaticNestedClass { // StaticNestedClass is a static nested class in OuterClass
        void accessMembers(OuterClass outer) {
            // Compiler error: Cannot make a static reference to the non-static
            //     field outerField
            // System.out.println(outerField);
            System.out.println(outer.outerField); // outerField is a field in OuterClass
            System.out.println(staticOuterField); // staticOuterField is a field in OuterClass
        }
    }

    public static void main(String[] args) {
        System.out.println("Inner class:");
        System.out.println("------------");
        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.accessMembers();

        System.out.println("\nStatic nested class:");
        System.out.println("--------------------");
        StaticNestedClass staticNestedObject = new StaticNestedClass();
        staticNestedObject.accessMembers(outerObject);

        System.out.println("\nTop-level class:");
        System.out.println("--------------------");
        TopLevelClass topLevelObject = new TopLevelClass();
        topLevelObject.accessMembers(outerObject);
    }
}
