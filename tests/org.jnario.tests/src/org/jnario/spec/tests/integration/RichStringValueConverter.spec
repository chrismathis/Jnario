package org.jnario.spec.tests.integration

import static extension org.junit.Assert.*

describe "RichStringValueConverter integration test" {
	fact '''Test1''' => "Test1" 
	
	fact '''
Test2''' => "Test2"

	fact '''
    Test3''' => "Test3"

	fact '''
    Test4
   Line2''' => " Test4\nLine2"

	fact '''
    Test5
   Line2
Line3''' => "    Test5\n   Line2\nLine3"

	fact '''Test   ''' => "Test   "

	fact '''
Test
Test2   ''' => "Test\nTest2   "

	fact '''
Line1

Line2''' => "Line1\n\nLine2"

	fact '''Line3

Line4''' => "Line3\n\nLine4"

	fact "Test\n   \n".assertEquals('''
Test
   
''') 

	fact '''Test
   ''' => "Test\n"
	
	fact '''
Test6
   ''' => "Test6\n"
   
    fact '''Test111
   '''.assertEquals("Test111\n")
}