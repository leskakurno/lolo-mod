package ru.lolo.seasons.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/** Жаровня Тринадцати Огней: светит на уровне 13, частицы рисуются только на клиенте. */
public class BrazierBlock extends Block {
    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(5, 0, 5, 11, 2, 11),
            Block.box(7, 2, 7, 9, 7, 9),
            Block.box(3, 7, 3, 13, 10, 13));

    public BrazierBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        double x = pos.getX() + 0.5D + (random.nextDouble() - 0.5D) * 0.4D;
        double y = pos.getY() + 1.0D;
        double z = pos.getZ() + 0.5D + (random.nextDouble() - 0.5D) * 0.4D;
        if (random.nextInt(2) == 0) {
            level.addParticle(ParticleTypes.FLAME, x, y, z, 0.0D, 0.01D, 0.0D);
        }
        if (random.nextInt(4) == 0) {
            level.addParticle(ParticleTypes.SMOKE, x, y + 0.2D, z, 0.0D, 0.03D, 0.0D);
        }
    }
}
