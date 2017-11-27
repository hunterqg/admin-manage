package com.cm.mm.rules;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qingao on 2017/11/22.
 */
public class RulesFactory {
    static private Map<String,List<Integer>> rules = new HashMap<>();
    public static final String KEY_BODY_SHAPE_A1 = "BODY_SHAPE_A1";
    public static final String KEY_BODY_SHAPE_A2 = "BODY_SHAPE_A2";
    public static final String KEY_BODY_SHAPE_A3 = "BODY_SHAPE_A3";
    public static final String KEY_BODY_SHAPE_B1 = "BODY_SHAPE_B1";
    public static final String KEY_BODY_SHAPE_B2 = "BODY_SHAPE_B2";
    public static final String KEY_BODY_SHAPE_B3 = "BODY_SHAPE_B3";
    public static final String KEY_BODY_SHAPE_C1 = "BODY_SHAPE_C1";
    public static final String KEY_BODY_SHAPE_C2 = "BODY_SHAPE_C2";
    public static final String KEY_BODY_SHAPE_C3 = "BODY_SHAPE_C3";

    public static final String KEY_COLOR_BRIGHT = "COLOR_BRIGHT";
    public static final String KEY_COLOR_DEGREE = "COLOR_DEGREE";
    private RulesFactory() {
        List<Integer> shapePreferredTags = Arrays.asList( //体型合适标签
                new Integer[]{
                        1,
                        2,
                        3,
                        4,
                        5
                }
        );
        rules.put(KEY_BODY_SHAPE_A1,shapePreferredTags);

        List<Integer> brightPreferredTags = Arrays.asList(
                new Integer[] {
                        6,
                        7,
                        8,
                        9
                }
        );
        rules.put(KEY_COLOR_BRIGHT,brightPreferredTags);

    }

    public static List<Integer> getRules (String key){
        new RulesFactory();
        return rules.get(key);
    }
}
