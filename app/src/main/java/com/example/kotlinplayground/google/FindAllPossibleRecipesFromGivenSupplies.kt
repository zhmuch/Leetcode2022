package com.example.kotlinplayground.google

/**
 * 2115. Find All Possible Recipes from Given Supplies
 *
 * https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
 */
class FindAllPossibleRecipesFromGivenSupplies {

    /**
     * Solution 1:
     *
     * BFS
     *
     * Repeated BFS till no any more finding
     *
     * Put all supplies into a HashSet, seen, for checking the availability in O(1) time;
     * Put into a Queue all indexes of the recipes;
     * BFS and put into seen all recipes that we currently can create; put back into the Queue if a recipe we currently can not create;
     * After any round of breadth search, if no any more recipe we can create, return the recipes we found so far.
     *
     */
    fun findAllRecipes(recipes: Array<String>, ingredients: List<List<String>>, supplies: Array<String>): List<String> {

    }

    /**
     * Solution 2:
     *
     * Topological sort
     *
     * 1. For each recipe, count its non-available ingredients as in degree; Store (non-available ingredient, dependent recipes) as HashMap;
     * 2. Store all 0-in-degree recipes into a list as the starting points of topological sort;
     * 3. Use topogical sort to decrease the in degree of recipes, whenever the in-degree reaches 0, add it to return list.
     *
     * check: https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/discuss/1646584/JavaPython-3-Toplogical-Sort-w-brief-explanation.
     */
}
