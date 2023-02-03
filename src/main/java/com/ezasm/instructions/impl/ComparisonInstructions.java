package com.ezasm.instructions.impl;

import com.ezasm.Conversion;
import com.ezasm.instructions.Instruction;
import com.ezasm.instructions.targets.input.AbstractInput;
import com.ezasm.instructions.targets.output.AbstractOutput;
import com.ezasm.simulation.Simulator;

import java.util.function.BinaryOperator;

/**
 * An implementation of standard comparison instructions for the simulation.
 */
public class ComparisonInstructions {

    private final Simulator simulator;

    /**
     * Some instructions require access to the Simulator directly, so that is provided.
     * @param simulator the provided Simulator.
     */
    public ComparisonInstructions(Simulator simulator) {
        this.simulator = simulator;
    }

    /**
     * Template compare and store operation.
     * @param op operation to apply to the arguments.
     * @param input1 the left-hand side of the operation.
     * @param input2 the right-hand side of the operation.
     * @param output the output of the operation.
     */
    private void cmpStore(BinaryOperator<Long> op, AbstractInput input1, AbstractInput input2, AbstractOutput output) {

        long res = op.apply(Conversion.bytesToLong(input1.get(simulator)), Conversion.bytesToLong(input2.get(simulator)));
        output.set(this.simulator, Conversion.longToBytes(res));
    }

    /**
     * The standard equals store operation.
     * @param input1 the left-hand side of the addition operation.
     * @param input2 the right-hand side of the addition operation.
     * @param output the output of the operation.
     */
    @Instruction
    public void seq(AbstractInput input1, AbstractInput input2, AbstractOutput output) {
        cmpStore((a, b) -> a.longValue() == b.longValue() ? 1L : 0L, input1, input2, output);
    }

    /**
     * The standard not equals store operation.
     * @param input1 the left-hand side of the addition operation.
     * @param input2 the right-hand side of the addition operation.
     * @param output the output of the operation.
     */
    @Instruction
    public void sne(AbstractInput input1, AbstractInput input2, AbstractOutput output) {
        cmpStore((a, b) -> a.longValue() != b.longValue() ? 1L : 0L, input1, input2, output);
    }

    /**
     * The standard less than store operation.
     * @param input1 the left-hand side of the addition operation.
     * @param input2 the right-hand side of the addition operation.
     * @param output the output of the operation.
     */
    @Instruction
    public void slt(AbstractInput input1, AbstractInput input2, AbstractOutput output) {
        cmpStore((a, b) -> a < b ? 1L : 0L, input1, input2, output);
    }

    /**
     * The standard greater than store operation.
     * @param input1 the left-hand side of the addition operation.
     * @param input2 the right-hand side of the addition operation.
     * @param output the output of the operation.
     */
    @Instruction
    public void sgt(AbstractInput input1, AbstractInput input2, AbstractOutput output) {
        cmpStore((a, b) -> a > b ? 1L : 0L, input1, input2, output);
    }

    /**
     * The standard less than or equals store operation.
     * @param input1 the left-hand side of the addition operation.
     * @param input2 the right-hand side of the addition operation.
     * @param output the output of the operation.
     */
    @Instruction
    public void sle(AbstractInput input1, AbstractInput input2, AbstractOutput output) {
        cmpStore((a, b) -> a <= b ? 1L : 0L, input1, input2, output);
    }

    /**
     * The standard greater than or equals operation.
     * @param input1 the left-hand side of the addition operation.
     * @param input2 the right-hand side of the addition operation.
     * @param output the output of the operation.
     */
    @Instruction
    public void sge(AbstractInput input1, AbstractInput input2, AbstractOutput output) {
        cmpStore((a, b) -> a >= b ? 1L : 0L, input1, input2, output);
    }
}
