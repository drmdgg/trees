package drmdgg.marijuanacraft.init.blocks.trees;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class PotLeaves extends LeavesBlock{

	public PotLeaves(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}
	public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
	      return type == EntityType.OCELOT || type == EntityType.PARROT;
	   }


}