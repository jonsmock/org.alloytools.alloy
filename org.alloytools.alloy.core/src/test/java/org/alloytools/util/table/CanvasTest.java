package org.alloytools.util.table;

import static org.junit.Assert.*;

import org.alloytools.util.table.Canvas;
import org.junit.Test;

public class CanvasTest {

	@Test
	public void testCanvas() {
		Canvas c = new Canvas(10, 10);
		c.box(0, 0, 10, 10);
		assertEquals(//
				"" +
						"┌────────┐\n" +
						"│        │\n" +
						"│        │\n" +
						"│        │\n" +
						"│        │\n" +
						"│        │\n" +
						"│        │\n" +
						"│        │\n" +
						"│        │\n" +
						"└────────┘\n" +
						"",
				c.toString());
		c.box(2, 2, 6, 6);
		assertEquals(
				"" +
						"┌────────┐\n" +
						"│        │\n" +
						"│ ┌────┐ │\n" +
						"│ │    │ │\n" +
						"│ │    │ │\n" +
						"│ │    │ │\n" +
						"│ │    │ │\n" +
						"│ └────┘ │\n" +
						"│        │\n" +
						"└────────┘\n" +
						"",
				c.toString());

		c.box(0, 0, 6, 6);
		assertEquals(
				"" +
						"┌────┬───┐\n" +
						"│    │   │\n" +
						"│ ┌──┼─┐ │\n" +
						"│ │  │ │ │\n" +
						"│ │  │ │ │\n" +
						"├─┼──┘ │ │\n" +
						"│ │    │ │\n" +
						"│ └────┘ │\n" +
						"│        │\n" +
						"└────────┘\n" +
						"",
				c.toString());
		c.box(6, 6, 4, 4);
		assertEquals(
				"" +
						"┌────┬───┐\n" +
						"│    │   │\n" +
						"│ ┌──┼─┐ │\n" +
						"│ │  │ │ │\n" +
						"│ │  │ │ │\n" +
						"├─┼──┘ │ │\n" +
						"│ │   ┌┼─┤\n" +
						"│ └───┼┘ │\n" +
						"│     │  │\n" +
						"└─────┴──┘\n" +
						"",
				c.toString());
	}
	
	@Test
	public void testMerge() {
		Canvas c1 = new Canvas(10, 10);
		c1.box();
		Canvas c2 = new Canvas(5,5);
		c2.box();
		c1.merge(c2, 5, 5);
		assertEquals(
				"" +
						"┌────────┐\n" + 
						"│        │\n" + 
						"│        │\n" + 
						"│        │\n" + 
						"│        │\n" + 
						"│    ┌───┤\n" + 
						"│    │   │\n" + 
						"│    │   │\n" + 
						"│    │   │\n" + 
						"└────┴───┘\n" + 
						"",
				c1.toString());
		c1.merge(c2, 0, 0);
		c1.merge(c2, 4, 0);
		assertEquals(
				"" +
						"┌───┬───┬┐\n" + 
						"│   │   ││\n" + 
						"│   │   ││\n" + 
						"│   │   ││\n" + 
						"├───┴───┘│\n" + 
						"│    ┌───┤\n" + 
						"│    │   │\n" + 
						"│    │   │\n" + 
						"│    │   │\n" + 
						"└────┴───┘\n" + 
						"",
				c1.toString());
		
		c1.clear().box();
		c1.merge(c2, -3, -2);
		assertEquals(
				"" +
						" ┼───────┐\n" + 
						" │       │\n" + 
						"┼┘       │\n" + 
						"│        │\n" + 
						"│        │\n" + 
						"│        │\n" + 
						"│        │\n" + 
						"│        │\n" + 
						"│        │\n" + 
						"└────────┘\n" + 
						"",
				c1.toString());
		c1.merge(c2, 8, 8);
		assertEquals(
				"" +
						" ┼───────┐\n" + 
						" │       │\n" + 
						"┼┘       │\n" + 
						"│        │\n" + 
						"│        │\n" + 
						"│        │\n" + 
						"│        │\n" + 
						"│        │\n" + 
						"│       ┌┼\n" + 
						"└───────┼ \n" + 
						"",
				c1.toString());
	}
}
