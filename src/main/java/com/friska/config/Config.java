package com.friska.config;

public class Config {

    /**
     * Whether Jambda uses lazy or strict beta-reduction depends on this variable.
     * Change to strict beta-reduction by using the following code:
     * <code>
     *     Config.REDUCTION_MODE = ReductionMode.STRICT;
     * </code> <br>
     * Otherwise, the reduction mode will be set to lazy, by default.
     * */
    public static ReductionMode REDUCTION_MODE = ReductionMode.LAZY;

}
