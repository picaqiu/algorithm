package tree;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AlarmNode {

    private boolean isRoot;

    private boolean isLeaf;

    private String locationId;

    private List<AlarmNode> children;

    private AlarmNode father;

    private AtomicInteger alarmCount;


    public AlarmNode() {
        this.children = new ArrayList<>();
    }

    public boolean insert(AlarmNode alarmNode) {
        AlarmNode root = this;
        int index = Integer.parseInt(alarmNode.locationId) % 256;
        List<AlarmNode> node = root.children;
        node.set(index, alarmNode);
        alarmNode.isRoot = false;
        alarmNode.isLeaf = true;
        alarmNode.father = this;

        return true;
    }

    public void notify(@NotNull AlarmNode alarmNode, int number) {
        AlarmNode father = alarmNode.getFather();
        alarmNode.getAlarmCount().addAndGet(number);
        if (!father.isRoot) {
            notify(father, number);
        }
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public List<AlarmNode> getChildren() {
        return children;
    }

    public void setChildren(List<AlarmNode> children) {
        this.children = children;
    }

    public AlarmNode getFather() {
        return father;
    }

    public void setFather(AlarmNode father) {
        this.father = father;
    }

    public AtomicInteger getAlarmCount() {
        return alarmCount;
    }

    public void setAlarmCount(AtomicInteger alarmCount) {
        this.alarmCount = alarmCount;
    }
}
