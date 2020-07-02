package interview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class InterviewTest {
    private Interview interview;
    @Before
    public void init(){
        interview = new Interview();
    }

    @Test
    public void test_is_unique(){
        String s1 = "leetcode";
        String s2 = "abc";
        String s3 = "";
        assertFalse(interview.isUnique(s1));
        assertTrue(interview.isUnique(s2));
        assertTrue(interview.isUnique(s3));
    }
}