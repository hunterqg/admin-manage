package com.cm.mm.rules;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qingao on 2017/11/22.
 */
public class RulesFactory {
    static private Map<String,Map<String,List<Integer>>> rules = new HashMap<>();
    static private Map<String,String> recommendReasonMap = new HashMap<>();

    static private RulesFactory instance = new RulesFactory();
    public static final String KEY_BODY_SHAPE_A1 = "A1";
    public static final String KEY_BODY_SHAPE_A2 = "A2";
    public static final String KEY_BODY_SHAPE_A3 = "A3";
    public static final String KEY_BODY_SHAPE_B1 = "B1";
    public static final String KEY_BODY_SHAPE_B2 = "B2";
    public static final String KEY_BODY_SHAPE_B3 = "B3";
    public static final String KEY_BODY_SHAPE_C1 = "C1";
    public static final String KEY_BODY_SHAPE_C2 = "C2";
    public static final String KEY_BODY_SHAPE_C3 = "C3";
    public static final String KEY_BODY_SHAPE_A1_FORBID = "A1_FORBID";
    public static final String KEY_BODY_SHAPE_A2_FORBID = "A2_FORBID";
    public static final String KEY_BODY_SHAPE_A3_FORBID = "A3_FORBID";
    public static final String KEY_BODY_SHAPE_B1_FORBID = "B1_FORBID";
    public static final String KEY_BODY_SHAPE_B2_FORBID = "B2_FORBID";
    public static final String KEY_BODY_SHAPE_B3_FORBID = "B3_FORBID";
    public static final String KEY_BODY_SHAPE_C1_FORBID = "C1_FORBID";
    public static final String KEY_BODY_SHAPE_C2_FORBID = "C2_FORBID";
    public static final String KEY_BODY_SHAPE_C3_FORBID = "C3_FORBID";

    public static final String KEY_UP_VALUES = "KEY_UP_VALUES";
    public static final String KEY_DOWN_VALUES = "KEY_DOWN_VALUES";
    public static final String KEY_LOOSENESS_VALUES = "KEY_LOOSENESS_VALUES";
    public static final String KEY_THICKNESS_VALUES = "KEY_THICKNESS_VALUES";
    public static final String KEY_PATTERN_VALUES = "KEY_PATTERN_VALUES";
    public static final String KEY_COLLAR_VALUES = "KEY_COLLAR_VALUES";
    public static final String KEY_COLOR_VALUES = "KEY_COLOR_VALUES";
    public static final String KEY_STYLE_VALUES = "KEY_STYLE_VALUES";

    private RulesFactory() {
/////////////////A1
        Map<String,List<Integer>> a1PreferredMap = new HashMap<>();
        List<Integer> a1PreferredUpDressTags = Arrays.asList(
                new Integer[]{
                        10701,
                        10702
                }
        );
        a1PreferredMap.put(KEY_UP_VALUES,a1PreferredUpDressTags);

        List<Integer> a1PreferredDownDressTags = Arrays.asList(
                new Integer[]{
                        10801,
                        10803,
                        10805,
                        10806
                }
        );
        a1PreferredMap.put(KEY_DOWN_VALUES,a1PreferredDownDressTags);

        List<Integer> a1PreferredStyleTags = Arrays.asList(
                new Integer[]{
                        10601,
                        10602
                }
        );
        a1PreferredMap.put(KEY_STYLE_VALUES,a1PreferredStyleTags);

        List<Integer> a1PreferredLoosenessTags = Arrays.asList(
                new Integer[]{
                        10201,
                        10202
                }
        );
        a1PreferredMap.put(KEY_LOOSENESS_VALUES,a1PreferredLoosenessTags);

        rules.put(KEY_BODY_SHAPE_A1,a1PreferredMap);
////////////A2
        Map<String,List<Integer>> a2PreferredMap = new HashMap<>();

        List<Integer> a2PreferredUpDressTags = Arrays.asList(
                new Integer[]{
                        10701,
                        10702
                }
        );
        a2PreferredMap.put(KEY_UP_VALUES,a2PreferredUpDressTags);

        List<Integer> a2PreferredDownDressTags = Arrays.asList(
                new Integer[]{
                        10801,
                        10802,
                        10803,
                        10805,
                        10806
                }
        );
        a2PreferredMap.put(KEY_DOWN_VALUES,a2PreferredDownDressTags);

        List<Integer> a2PreferredStyleTags = Arrays.asList(
                new Integer[]{
                        10601,
                        10602,
                        10605
                }
        );
        a2PreferredMap.put(KEY_STYLE_VALUES,a2PreferredStyleTags);

        List<Integer> a2PreferredThicknessTags = Arrays.asList(
                new Integer[]{
                        10301,
                        10302,
                        10303
                }
        );
        a2PreferredMap.put(KEY_THICKNESS_VALUES,a2PreferredThicknessTags);

        List<Integer> a2PreferredLoosenessTags = Arrays.asList(
                new Integer[]{
                        10201,
                        10202
                }
        );
        a2PreferredMap.put(KEY_LOOSENESS_VALUES,a2PreferredLoosenessTags);
        rules.put(KEY_BODY_SHAPE_A2,a2PreferredMap);

/////////////A3
        Map<String,List<Integer>> a3PreferredMap = new HashMap<>();

        List<Integer> a3PreferredUpDressTags = Arrays.asList(
                new Integer[]{
                        10702
                }
        );
        a3PreferredMap.put(KEY_UP_VALUES,a3PreferredUpDressTags);

        List<Integer> a3PreferredDownDressTags = Arrays.asList(
                new Integer[]{
                        10803,
                        10806
                }
        );
        a3PreferredMap.put(KEY_DOWN_VALUES,a3PreferredDownDressTags);

        List<Integer> a3PreferredStyleTags = Arrays.asList(
                new Integer[]{
                        10601,
                        10604,
                        10605
                }
        );
        a3PreferredMap.put(KEY_STYLE_VALUES,a3PreferredStyleTags);

        List<Integer> a3PreferredThicknessTags = Arrays.asList(
                new Integer[]{
                        10301,
                        10302
                }
        );
        a3PreferredMap.put(KEY_THICKNESS_VALUES,a3PreferredThicknessTags);

        List<Integer> a3PreferredLoosenessTags = Arrays.asList(
                new Integer[]{
                        10202,
                        10203
                }
        );
        a3PreferredMap.put(KEY_LOOSENESS_VALUES,a3PreferredLoosenessTags);

        List<Integer> a3PreferredCollarTags = Arrays.asList(
                new Integer[]{
                        10101
                }
        );
        a3PreferredMap.put(KEY_COLLAR_VALUES,a3PreferredCollarTags);

        List<Integer> a3PreferredColorTags = Arrays.asList(
                new Integer[]{
                        10501
                }
        );
        a3PreferredMap.put(KEY_COLOR_VALUES,a3PreferredColorTags);

        rules.put(KEY_BODY_SHAPE_A3,a3PreferredMap);


/////////////////B1
        Map<String,List<Integer>> b1PreferredMap = new HashMap<>();
        List<Integer> b1PreferredUpDressTags = Arrays.asList(
                new Integer[]{
                        10701,
                        10702,
                        10703
                }
        );
        b1PreferredMap.put(KEY_UP_VALUES,b1PreferredUpDressTags);

        List<Integer> b1PreferredDownDressTags = Arrays.asList(
                new Integer[]{
                        10801,
                        10803,
                        10805,
                        10806,
                        10807
                }
        );
        b1PreferredMap.put(KEY_DOWN_VALUES,b1PreferredDownDressTags);

        List<Integer> b1PreferredStyleTags = Arrays.asList(
                new Integer[]{
                        10604,
                        10605,
                        10607
                }
        );
        b1PreferredMap.put(KEY_STYLE_VALUES,b1PreferredStyleTags);

        List<Integer> b1PreferredLoosenessTags = Arrays.asList(
                new Integer[]{
                        10201,
                        10202,
                        10203
                }
        );
        b1PreferredMap.put(KEY_LOOSENESS_VALUES,b1PreferredLoosenessTags);

        rules.put(KEY_BODY_SHAPE_B1,b1PreferredMap);

////////////B2
        Map<String,List<Integer>> b2PreferredMap = new HashMap<>();

        List<Integer> b2PreferredUpDressTags = Arrays.asList(
                new Integer[]{
                        10701,
                        10702,
                        10703
                }
        );
        b2PreferredMap.put(KEY_UP_VALUES,b2PreferredUpDressTags);

        List<Integer> b2PreferredDownDressTags = Arrays.asList(
                new Integer[]{
                        10801,
                        10803,
                        10804,
                        10806,
                        10807
                }
        );
        b2PreferredMap.put(KEY_DOWN_VALUES,b2PreferredDownDressTags);

        List<Integer> b2PreferredStyleTags = Arrays.asList(
                new Integer[]{
                        10601,
                        10603,
                        10604,
                        10605,
                        10607
                }
        );
        b2PreferredMap.put(KEY_STYLE_VALUES,b2PreferredStyleTags);

        List<Integer> b2PreferredThicknessTags = Arrays.asList(
                new Integer[]{
                        10301,
                        10302,
                        10303
                }
        );
        b2PreferredMap.put(KEY_THICKNESS_VALUES,b2PreferredThicknessTags);

        List<Integer> b2PreferredLoosenessTags = Arrays.asList(
                new Integer[]{
                        10201,
                        10202
                }
        );
        b2PreferredMap.put(KEY_LOOSENESS_VALUES,b2PreferredLoosenessTags);
        rules.put(KEY_BODY_SHAPE_B2,b2PreferredMap);

/////////////B3
        Map<String,List<Integer>> b3PreferredMap = new HashMap<>();

        List<Integer> b3PreferredUpDressTags = Arrays.asList(
                new Integer[]{
                        10701,
                        10703,
                        10704
                }
        );
        b3PreferredMap.put(KEY_UP_VALUES,b3PreferredUpDressTags);

        List<Integer> b3PreferredDownDressTags = Arrays.asList(
                new Integer[]{
                        10802,
                        10803,
                        10806,
                        10808
                }
        );
        b3PreferredMap.put(KEY_DOWN_VALUES,b3PreferredDownDressTags);

        List<Integer> b3PreferredStyleTags = Arrays.asList(
                new Integer[]{
                        10601,
                        10603,
                        10604,
                        10605
                }
        );
        b3PreferredMap.put(KEY_STYLE_VALUES,b3PreferredStyleTags);

        List<Integer> b3PreferredThicknessTags = Arrays.asList(
                new Integer[]{
                        10301,
                        10302
                }
        );
        b3PreferredMap.put(KEY_THICKNESS_VALUES,b3PreferredThicknessTags);

        List<Integer> b3PreferredLoosenessTags = Arrays.asList(
                new Integer[]{
                        10202,
                        10203
                }
        );
        b3PreferredMap.put(KEY_LOOSENESS_VALUES,b3PreferredLoosenessTags);

        List<Integer> b3PreferredColorTags = Arrays.asList(
                new Integer[]{
                        10501
                }
        );
        b3PreferredMap.put(KEY_COLOR_VALUES,b3PreferredColorTags);

        rules.put(KEY_BODY_SHAPE_B3,b3PreferredMap);

        /////////////////C1
        Map<String,List<Integer>> c1PreferredMap = new HashMap<>();
        List<Integer> c1PreferredUpDressTags = Arrays.asList(
                new Integer[]{
                        10702,
                        10703,
                        10704
                }
        );
        c1PreferredMap.put(KEY_UP_VALUES,c1PreferredUpDressTags);

        List<Integer> c1PreferredDownDressTags = Arrays.asList(
                new Integer[]{
                        10801,
                        10802,
                        10803,
                        10806,
                        10807,
                        10808
                }
        );
        c1PreferredMap.put(KEY_DOWN_VALUES,c1PreferredDownDressTags);

        List<Integer> c1PreferredStyleTags = Arrays.asList(
                new Integer[]{
                        10601,
                        10603,
                        10605
                }
        );
        c1PreferredMap.put(KEY_STYLE_VALUES,c1PreferredStyleTags);

        List<Integer> c1PreferredLoosenessTags = Arrays.asList(
                new Integer[]{
                        10202,
                        10203
                }
        );
        c1PreferredMap.put(KEY_LOOSENESS_VALUES,c1PreferredLoosenessTags);

        rules.put(KEY_BODY_SHAPE_C1,c1PreferredMap);
////////////C2
        Map<String,List<Integer>> c2PreferredMap = new HashMap<>();

        List<Integer> c2PreferredUpDressTags = Arrays.asList(
                new Integer[]{
                        10702,
                        10703,
                        10704
                }
        );
        c2PreferredMap.put(KEY_UP_VALUES,c2PreferredUpDressTags);

        List<Integer> c2PreferredDownDressTags = Arrays.asList(
                new Integer[]{
                        10801,
                        10803,
                        10804,
                        10806,
                        10807,
                        10808
                }
        );
        c2PreferredMap.put(KEY_DOWN_VALUES,c2PreferredDownDressTags);

        List<Integer> c2PreferredStyleTags = Arrays.asList(
                new Integer[]{
                        10601,
                        10603,
                        10604,
                        10605,
                        10607
                }
        );
        c2PreferredMap.put(KEY_STYLE_VALUES,c2PreferredStyleTags);

        List<Integer> c2PreferredThicknessTags = Arrays.asList(
                new Integer[]{
                        10301,
                        10302,
                        10303
                }
        );
        c2PreferredMap.put(KEY_THICKNESS_VALUES,c2PreferredThicknessTags);

        List<Integer> c2PreferredLoosenessTags = Arrays.asList(
                new Integer[]{
                        10202,
                        10203
                }
        );
        c2PreferredMap.put(KEY_LOOSENESS_VALUES,c2PreferredLoosenessTags);
        rules.put(KEY_BODY_SHAPE_C2,c2PreferredMap);

/////////////C3
        Map<String,List<Integer>> c3PreferredMap = new HashMap<>();

        List<Integer> c3PreferredUpDressTags = Arrays.asList(
                new Integer[]{
                        10702,
                        10703,
                        10704
                }
        );
        c3PreferredMap.put(KEY_UP_VALUES,c3PreferredUpDressTags);

        List<Integer> c3PreferredDownDressTags = Arrays.asList(
                new Integer[]{
                        10802,
                        10803,
                        10806,
                        10807,
                        10808
                }
        );
        c3PreferredMap.put(KEY_DOWN_VALUES,c3PreferredDownDressTags);

        List<Integer> c3PreferredStyleTags = Arrays.asList(
                new Integer[]{
                        10601,
                        10604,
                        10605
                }
        );
        c3PreferredMap.put(KEY_STYLE_VALUES,c3PreferredStyleTags);

        List<Integer> c3PreferredThicknessTags = Arrays.asList(
                new Integer[]{
                        10301,
                        10302
                }
        );
        c3PreferredMap.put(KEY_THICKNESS_VALUES,c3PreferredThicknessTags);

        List<Integer> c3PreferredLoosenessTags = Arrays.asList(
                new Integer[]{
                        10202,
                        10203
                }
        );
        c3PreferredMap.put(KEY_LOOSENESS_VALUES,c3PreferredLoosenessTags);

        List<Integer> c3PreferredColorTags = Arrays.asList(
                new Integer[]{
                        10501
                }
        );
        c3PreferredMap.put(KEY_COLOR_VALUES,c3PreferredColorTags);

        rules.put(KEY_BODY_SHAPE_C3,c3PreferredMap);


        //FORBID Rules
        Map<String,List<Integer>> forbidMap = new HashMap<>();
        List<Integer> forbidLoosenessTags = Arrays.asList(
                new Integer[]{
                        10201
                }
        );
        forbidMap.put(KEY_LOOSENESS_VALUES,forbidLoosenessTags);
        List<Integer> forbidThicknessTags = Arrays.asList(
                new Integer[]{
                        10303
                }
        );
        forbidMap.put(KEY_THICKNESS_VALUES,forbidThicknessTags);

        List<Integer> forbidCollarTags = Arrays.asList(
                new Integer[]{
                        10103
                }
        );
        forbidMap.put(KEY_COLLAR_VALUES,forbidCollarTags);

        List<Integer> forbidPatternTags = Arrays.asList(
                new Integer[]{
                        10401,
                        10404,
                        10405
                }
        );
        forbidMap.put(KEY_PATTERN_VALUES,forbidPatternTags);

        rules.put(KEY_BODY_SHAPE_A3_FORBID,forbidMap);
        rules.put(KEY_BODY_SHAPE_B3_FORBID,forbidMap);
        rules.put(KEY_BODY_SHAPE_C3_FORBID,forbidMap);


        //recommend reason map
        recommendReasonMap.put(KEY_BODY_SHAPE_A1,"身材娇小适合年轻&活力款");
        recommendReasonMap.put(KEY_BODY_SHAPE_B1,"身材纤细，混搭造型+潮流轮廓，瞬间点亮全身");
        recommendReasonMap.put(KEY_BODY_SHAPE_C1,"身材高挑，百搭单品让你时尚零时差");
        recommendReasonMap.put(KEY_BODY_SHAPE_A2,"身材娇小，摩登风格，精致出众");
        recommendReasonMap.put(KEY_BODY_SHAPE_B2,"身材完美，独特&现代的款式突出气质");
        recommendReasonMap.put(KEY_BODY_SHAPE_C2,"身材高挑，随性&有型的款式可轻松驾驭");
        recommendReasonMap.put(KEY_BODY_SHAPE_A3,"身材匀称，简约线条，极其显瘦");
        recommendReasonMap.put(KEY_BODY_SHAPE_B3,"身材匀称，减重搭配，调整比例");
        recommendReasonMap.put(KEY_BODY_SHAPE_C3,"身材匀称，时髦轮廓，一秒显瘦");
    }

    public static Map<String,List<Integer>> getRules (String key){
        return rules.get(key);
    }

    public String getRecommendReason(String key) {
        return recommendReasonMap.get(key);
    }
}
