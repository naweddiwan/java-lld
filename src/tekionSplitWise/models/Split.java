package tekionSplitWise.models;

import lombok.Getter;

import java.util.List;

@Getter
public class Split {
    private SplitType splitType;
    private List<SplitEntry> splitEntries;

    public Split(SplitType splitType, List<SplitEntry> splitEntries) {
        this.splitType = splitType;
        this.splitEntries = splitEntries;
    }
}
