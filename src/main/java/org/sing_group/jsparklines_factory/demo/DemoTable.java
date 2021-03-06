package org.sing_group.jsparklines_factory.demo;

import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXTable;

import no.uib.jsparklines.data.XYDataPoint;

public class DemoTable extends JXTable {
	private static final long serialVersionUID = 1L;
	
	public static final String COLUMN_1 = "Column 1";
	public static final String COLUMN_2 = "Column 2";
	public static final String COLUMN_3 = "Column 3";
	public static final String COLUMN_4 = "Column 4";
	public static final String COLUMN_5 = "Column 5";
	public static final String COLUMN_6 = "Column 6";
	
	private static final String COLUMN_NAMES[] = 
		{ COLUMN_1 , COLUMN_2, COLUMN_3, COLUMN_4, COLUMN_5, COLUMN_6 };

	private static final XYDataPoint XY_POS_0 = new XYDataPoint(10, 0.01);
	private static final XYDataPoint XY_POS_1 = new XYDataPoint(9, 0.02);
	private static final XYDataPoint XY_POS_2 = new XYDataPoint(4, 0.06);
	private static final XYDataPoint XY_POS_3 = new XYDataPoint(2, 0.07);

	private static final XYDataPoint XY_POS_NEG_0 = new XYDataPoint(10, 0.01);
	private static final XYDataPoint XY_POS_NEG_1 = new XYDataPoint(5, 0.06);
	private static final XYDataPoint XY_POS_NEG_2 = new XYDataPoint(-5, 0.01);
	private static final XYDataPoint XY_POS_NEG_3 = new XYDataPoint(-10, 0.06);

	private static final Object ROW_DATA[][] =
		{
			{ 1, 1d, XY_POS_0, XY_POS_NEG_0, 	-1d, 	-1d	},
			{ 3, 3d, XY_POS_1, XY_POS_NEG_1, 	-3d, 	-3d	},
			{ 7, 7d, XY_POS_2, XY_POS_NEG_2, 	1d, 	1d	},
			{ 4, 4d, XY_POS_3, XY_POS_NEG_3, 	3d, 	3d	}
		};

	public DemoTable() {
		super(new DefaultTableModel(ROW_DATA, COLUMN_NAMES) {
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				switch (columnIndex) {
				case 0:
					return Integer.class;
				case 1:
					return Double.class;
				case 2:
					return XYDataPoint.class;
				case 3:
					return XYDataPoint.class;
				case 4:
					return Integer.class;
				case 5:
					return Integer.class;
				default:
					break;
				}
				throw new IllegalStateException();
			}
		});
	}
}
