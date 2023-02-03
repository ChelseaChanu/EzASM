package com.ezasm.instructions.impl;

import com.ezasm.Conversion;
import com.ezasm.instructions.Instruction;
import com.ezasm.instructions.targets.input.AbstractInput;
import com.ezasm.instructions.targets.output.AbstractOutput;
import com.ezasm.simulation.Simulator;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * An implementation of standard branch instructions for the simulation.
 */
public class BranchInstructions {

    private final Simulator simulator;

    /**
     * Some instructions require access to the Simulator directly, so that is provided.
     * @param simulator the provided Simulator.
     */
    public BranchInstructions(Simulator simulator) {
        this.simulator = simulator;
    }

    /**
     * Template compare and store operation.
     * @param op operation to apply to the arguments.
     * @param input1 the left-hand side of the operation.
     * @param input2 the right-hand side of the operation.
     * @param label the target label of the branch.
     */
    private void branch(BiFunction<Long, Long, Boolean> op, AbstractInput input1, AbstractInput input2, AbstractInput label) {

        boolean res = op.apply(Conversion.bytesToLong(input1.get(simulator)), Conversion.bytesToLong(input2.get(simulator)));
        if (res) simulator.getRegister("pc").setBytes(label.get(simulator));
    }

    /**
     * The standard equals store operation.
     * @param input1 the left-hand side of the conditional operation.
     * @param input2 the right-hand side of the conditional operation.
     * @param label the target label of the branch.
     */
    @Instruction
    public void beq(AbstractInput input1, AbstractInput input2, AbstractInput label) {
        branch(Objects::equals, input1, input2, label);
    }
}
