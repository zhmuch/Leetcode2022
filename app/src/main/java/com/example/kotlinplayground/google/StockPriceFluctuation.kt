package com.example.kotlinplayground.google

/**
 * 2034. Stock Price Fluctuation
 *
 * https://leetcode.com/problems/stock-price-fluctuation/
 */
class StockPriceFluctuation {

    fun update(timestamp: Int, price: Int) {

    }

    fun current(): Int {

    }

    fun maximum(): Int {

    }

    fun minimum(): Int {

    }

    /**
     * More about data structure
     */

    /**
     * Solution 1:
     *
     * 1. linked list of StockNode based on price
     * 2. hashmap (time, StockNode)
     */

    /**
     * Solution 2:
     *
     * Hashed and Sorted Map
     *
     * We will use a hashmap (timestampPriceMap) to store the price of the stocks.
     * A hashmap stores the elements as key-value pairs. Here, our key is the timestamp and the
     * value is the price of the stock at the respective timestamp, i.e. the hashmap maps timestamp to price.
     *
     * Now, we will use a sorted map (priceFrequency) to store the stock prices in increasing order.
     * A sorted map also stores the elements as key-value pairs and keeps elements sorted on the
     * basis of the key. Thus, we will store the price of the stocks as the key and its occurrence (count)
     * in our records stream as the value, i.e. the sorted map maps the price to the frequency.
     * It denotes how many times a price is present in our records stream.
     */

    /**
     * Solution 3:
     *
     * Hashmap and Heaps
     *
     * In this approach, again, we will use a hashmap (timestampPriceMap) to record the stock's price at each timestamp.
     *
     * However, it is not necessary for us to maintain a sorted map as we did in the previous approach.
     * Any time we need to efficiently keep track of the lowest or highest value, we should consider using a heap data structure.
     * Here, we will store each record in 2 different heaps, a min-heap to efficiently track the lowest
     * stock price and a max-heap to efficiently track the highest stock price.
     *
     * Now the real challenge will be, how to update stock prices?
     * One way to resolve this issue is every time we get a new price, we push it into each heap,
     * and only while getting the top element we need to verify if the price is correct or outdated.
     * use our hashmap (timestampPriceMap) to check which prices are outdated
     */
}
