package org.lab4;

import java.lang.reflect.Field;
import java.util.List;

public class XMLSerializer {
    public static String parse(Object obj, int level) throws IllegalAccessException {
        if (obj == null) return "";

        // Handle Primitives and Strings directly
        if (obj instanceof String || obj instanceof Number || obj instanceof Boolean) {
            return obj.toString();
        }

        // Handle Lists (Wrap elements in <Item> tags)
        if (obj instanceof List<?> objectList) {
            StringBuilder b = new StringBuilder();
            String indentation = "  ".repeat(level);
            for (Object item : objectList) {
                b.append(indentation).append("<Item>\n");
                b.append(parse(item, level + 1)).append("\n");
                b.append(indentation).append("</Item>\n");
            }
            return b.toString().trim();
        }

        // Handle General Objects (Recursive Serialization)
        Class<?> c = obj.getClass();
        String indentation = "  ".repeat(level);
        StringBuilder s = new StringBuilder();

        // Only add class tags for the root object or nested objects (not for primitive values)
        s.append(indentation).append("<").append(c.getSimpleName()).append(">\n");

        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            Object value = f.get(obj);
            String fieldName = f.getName();
            String fieldIndent = "  ".repeat(level + 1);

            s.append(fieldIndent).append("<").append(fieldName).append(">");
            
            // If it's a simple type, keep it on one line; otherwise, newline for recursion
            if (value instanceof String || value instanceof Number || value instanceof Boolean) {
                s.append(parse(value, 0));
            } else {
                s.append("\n").append(parse(value, level + 2)).append("\n").append(fieldIndent);
            }
            
            s.append("</").append(fieldName).append(">\n");
        }

        s.append(indentation).append("</").append(c.getSimpleName()).append(">");
        return s.toString();
    }
}