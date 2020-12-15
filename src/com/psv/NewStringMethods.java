package com.psv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class NewStringMethods {
    public static void main(String[] args) throws IOException {
        // JDK 11
        isBlanc();
        lines();
        strip();
        repeat();
        // JDK 12
        indent();
        transform();
        // JDK 13
        textBlocks();
        formatted();
        stripIndent();
        translateEscapes();
    }

    private static void isBlanc() {
        System.out.println(" ".isBlank()); // true
        System.out.println("Not blank".isBlank()); // false
        System.out.println("".isBlank()); // true
    }

    private static void lines() {
        String str = "A\nB\nC";
        System.out.println(str.lines().collect(Collectors.toList())); // [A, B, C]
    }

    private static void strip() {
        String str = " TEXT ";
        System.out.println("<" + str.strip() + ">"); // <TEXT>
        System.out.println("<" + str.stripLeading() + ">"); // <TEXT >
        System.out.println("<" + str.stripTrailing() + ">"); // < TEXT>
        str = " TEXT ";
        System.out.println("<" + str.trim() + ">"); // < TEXT >
        System.out.println("<" + str.strip() + ">"); // <TEXT>
    }

    private static void repeat() {
        System.out.println("123".repeat(3)); // 123123123
    }

    private static void indent() {
        String str = "A\nB\n\tC";
        System.out.println("<" + str.indent(0) + ">");
        /*
        <A
        B
            C
        >
        */
        System.out.println("<" + str.indent(3) + ">");
        /*
        <   A
           B
            C
        >
        */
        System.out.println("<" + str.indent(-3) + ">");
        /*
        <A
        B
        C
        >
        */
    }

    private static void transform() {
        System.out.println(" abcd ".transform(String::strip)
                .<String>transform(String::toUpperCase)); // ABCD
    }

    private static void textBlocks() {
        //language=JSON
        String textBlock = """
               {
                    "a": "a",
                    "b": 1,
                    "c": [1, 2, 3],
                    "d": {
                        "e": null
                    }
               }
               """;
        //language=JSON
        String string = "{\n" +
                        "     \"a\": \"a\",\n" +
                        "     \"b\": 1,\n" +
                        "     \"c\": [1, 2, 3],\n" +
                        "     \"d\": {\n" +
                        "         \"e\": null\n" +
                        "     }\n" +
                        "}\n";

        System.out.println(textBlock.equals(string)); // true
    }

    private static void formatted() {
        System.out.println("This is %s %d".formatted("Java", 15));
        System.out.println(String.format("This is %s %d", "Java", 15));
    }

    private static void stripIndent() {
        String string1 = "{ \n     \"a\": \"b\"\n} \n";
        String string2 = "{\n     \"a\": \"b\"\n}\n";

        System.out.println(string2.equals(string1)); // false
        System.out.println(string2.equals(string1.stripIndent())); // true
    }

    private static void translateEscapes() throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine(); // one\ttwo

        System.out.println(str); // one\ttwo
        System.out.println(str.translateEscapes()); // one	two
    }
}
