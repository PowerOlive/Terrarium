package net.gegy1000.terrarium.server.map.cover.generator;

import net.gegy1000.terrarium.server.map.cover.CoverGenerator;
import net.gegy1000.terrarium.server.map.cover.CoverType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import java.util.Random;

public class SnowCover extends CoverGenerator {
    private static final IBlockState SNOW = Blocks.SNOW.getDefaultState();

    public SnowCover() {
        super(CoverType.SNOW);
    }

    @Override
    protected IBlockState getCoverAt(Random random, int x, int z) {
        return SNOW;
    }

    @Override
    protected IBlockState getFillerAt(Random random, int x, int z) {
        return SNOW;
    }
}