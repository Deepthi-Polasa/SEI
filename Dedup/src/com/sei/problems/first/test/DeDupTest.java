package com.sei.problems.first.test;

import org.junit.*;

import com.sei.problems.first.DeDup;

import static org.junit.Assert.*;
import java.util.*;

/**
 * @author Deepthi Polasa 
 * @Dee *
 */
public class DeDupTest {
   
    @Test
    public void testEmptyArrayDeDup() {
    	int[] emptyArray = {};
    	assertTrue(DeDup.deDupWithHashSet(emptyArray).length==0);
    	assertTrue(DeDup.deDupBySorting(emptyArray).length==0);
    	assertTrue(DeDup.deDupAndPreserveOrgiOrderUsingStringObj(emptyArray).length==0);
    	assertTrue(DeDup.deDupAndPreserveOrgiOrder(emptyArray).length==0);
    }

    @Test
    public void testOneElementArrayDeDup() {
    	int[] oneEleArray = {10000};
    	assertTrue(Arrays.equals(oneEleArray,DeDup.deDupWithHashSet(oneEleArray)));
    	assertTrue(Arrays.equals(oneEleArray, DeDup.deDupBySorting(oneEleArray)));
    	assertTrue(Arrays.equals(oneEleArray, DeDup.deDupAndPreserveOrgiOrderUsingStringObj(oneEleArray)));
    	assertTrue(Arrays.equals(oneEleArray, DeDup.deDupAndPreserveOrgiOrder(oneEleArray)));
    }
    
    @Test
    public void testDuplicateElementArrayDeDup() {
    	int[] dupEleArray = {1,1,1,2,2,3,4,5,6,8,2,9,0};
    	//Order preserved DeDup Array
    	int[] uniqnum = {1,2,3,4,5,6,8,9,0};
    	//Sorted DeDup Array
    	int[] uniqnumSorted = {0,1,2,3,4,5,6,8,9};
    	
    	int[] tempArray = DeDup.deDupWithHashSet(dupEleArray);
    	Arrays.sort(tempArray);
    	assertTrue(Arrays.equals(uniqnumSorted,tempArray));
    	
    	assertTrue(Arrays.equals(uniqnumSorted, DeDup.deDupBySorting(dupEleArray)));
    	assertTrue(Arrays.equals(uniqnum, DeDup.deDupAndPreserveOrgiOrderUsingStringObj(dupEleArray)));
    	assertTrue(Arrays.equals(uniqnum, DeDup.deDupAndPreserveOrgiOrder(dupEleArray)));
    }
    
    
}