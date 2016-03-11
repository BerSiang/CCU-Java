package Java;

/**
 *  Rectangle.java
 *  @author Vincent Huang
 */

public class Rectangle {

    /**
     *  Rectangle左上角的 X 座標
     *  @see #setX(double)
     *  @see #getX()
     *  @see #setLocation(double, double)
     */
	private double x;

    /**
     *  Rectangle 左上角的Y座標
     *  @see #setX(double)
     *  @see #getY()
     *  @see #setLocation(double, double)
     */
	private double y;

    /**
     *  Rectangle 的寬度
     *  @see #setWidth(double)
     *  @see #getWidth()
     */
	private double width;

    /**
     *  Rectangle 的高度
     *  @see #setHeight(double)
     *  @see #getHeight()
     */
	private double height;

    /**
     *  建構 Rectangle 物件
     *  x, y, width, height預設皆為0
     */
    public Rectangle() {
        this(0, 0, 0, 0);
    }

    /**
     *  建構 Rectangle 物件
     *  @param x 指定 Rectangle 的X座標
     *  @param y 指定 Rectangle 的Y座標
     *  @param width 指定 Rectangle 的 width
     *  @param height 指定 Rectangle 的 height
     */
	public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     *  指定 Rectangle 的寬度
     *  @param width 指定 Rectangle 的 width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     *  指定 Rectangle 的高度
     *  @param height 指定 Rectangle 的 height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     *  指定 Rectangle 的X座標
     *  @param x 指定 Rectangle 的 x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     *  指定 Rectangle 的Y座標
     *  @param y 指定 Rectangle 的 y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     *  取得 Rectangle 的寬度
     *  @return Rectangle 的 width
     */
    public double getWidth() {
    	return width;
    }

    /**
     *  取得 Rectangle 的高度
     *  @return Rectangle 的 height
     */
    public double getHeight() {
    	return height;
    }

    /**
     *  取得 Rectangle 的X座標
     *  @return Rectangle 的 X
     */
    public double getX() {
    	return x;
    }

    /**
     *  取得 Rectangle 的Y座標
     *  @return Rectangle 的 y
     */
	public double getY() {
		return y;
	}

    /**
     *  取得 Rectangle 的面積
     *  @return Rectangle 的 width * height
     */
    public double getArea() {
    	return (double)width * height;
    }

    /**
     *  取得 Rectangle 的周長
     *  @return Rectangle 的 (width + height) * 2
     */
    public double getPerimeter() {
    	return (double)(width + height) * 2;
    }

    /**
     *  取得 Rectangle 的位置
     *  @return Rectangle 的 x, y
     */
    public String getLocation() {
    	return "(" + x + ", " + y + ")";
    }

    /**
     *  取得 Rectangle 的位置、寬、高
     *  @return Rectangle 的 x, y, width, height
     */
    public String toString() {
    	return getClass().getName() + "[x=" + x + ",y=" + y + ",width=" + width + ",height=" + height + "]";
    }
}