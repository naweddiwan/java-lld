package SplitWise.models.split;

import SplitWise.enums.SplitType;

import java.util.List;

public class Split {
    private SplitType splitType;
    List<SplitEntry> splitEntryList;

    public SplitType getSplitType() {
        return splitType;
    }

    public List<SplitEntry> getSplitEntryList() {
        return splitEntryList;
    }

    public Split(SplitType splitType, List<SplitEntry> splitEntryList) {
        this.splitType = splitType;
        this.splitEntryList = splitEntryList;
    }
}
