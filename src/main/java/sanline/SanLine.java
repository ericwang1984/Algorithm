package sanline;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SanLine {

  public int sanline(List<Interval> intervalList) {
    int ans = 0;
    List<Point> points = new ArrayList<>(intervalList.size() * 2);

    //拆为散点 装入列表
    for (Interval interval : intervalList) {
      points.add(new Point(interval.getStartPoint(), 1));
      points.add(new Point(interval.getEndPoint(), -1));
    }

    //针对散点排序，主要以时间排序
    Collections.sort(points, (Point p1, Point p2) -> {
      if (p1.x == p2.x) {
        return p1.y - p2.y;
      } else {
        return p1.x - p2.x;
      }
    });

    //根据有序散点的特征 求解
    int tmpRes = 0;
    for (Point p : points) {
      if (p.y > 0) {
        tmpRes = tmpRes + 1;
      } else {
        tmpRes = tmpRes - 1;
      }
      ans = Math.max(ans, tmpRes);
    }

    return ans;
  }

}

class Interval {

  private int startPoint;
  private int endPoint;

  public int getStartPoint() {
    return startPoint;
  }

  public void setStartPoint(int startPoint) {
    this.startPoint = startPoint;
  }

  public int getEndPoint() {
    return endPoint;
  }

  public void setEndPoint(int endPoint) {
    this.endPoint = endPoint;
  }

  public Interval(int startEndpoint, int highEndpoint) {
    this.startPoint = startEndpoint;
    this.endPoint = highEndpoint;
  }
}