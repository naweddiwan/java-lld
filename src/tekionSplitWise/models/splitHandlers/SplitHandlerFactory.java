package tekionSplitWise.models.splitHandlers;

import tekionSplitWise.models.SplitType;

public class SplitHandlerFactory {
    public SplitHandler getSplitHandler(SplitType splitType) {
        switch (splitType){
            case EQUAL:
                return new EqualSplitHandler();
            case UNEQUAL:
                return new UnequalSplitHandler();
            case PERCENTAGE:
                return new PercentageSplitHandler();
            default:
                throw new RuntimeException("Unknow Split Type");
        }
    }
}
