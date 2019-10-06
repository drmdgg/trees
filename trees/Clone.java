package drmdgg.marijuanacraft.init.blocks.trees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class Clone extends BushBlock implements IGrowable {

	

	public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;

	protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);

	public final Tree tree;

	

	public Clone(Tree p_i48337_1_, Block.Properties properties) {

		   

	super(properties);

	this.tree = p_i48337_1_;

	this.setDefaultState(this.stateContainer.getBaseState().with(STAGE, Integer.valueOf(0)));

	

	}

	

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		      

		return SHAPE;

		  

	}

	

	public boolean isOpaqueCube(BlockState state) {

		

		return false;

		

	}

	

	public boolean isFullCube(BlockState state) {

		

		return false;

		

	}

	

	@Override

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {

		

		return (double)worldIn.rand.nextFloat() < 0.45D;

		

	}

	

	protected boolean canSustainBush(BlockState state) {

		

		return state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.FARMLAND;

		

	}

	

	public void grow(IWorld worldIn, BlockPos pos, BlockState state, Random rand) {

		     

		if (state.get(STAGE) == 0) {

		

			worldIn.setBlockState(pos, state.cycle(STAGE), 4);

		    

		} else {

		    

			if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(worldIn, rand, pos)) return;

	        this.tree.spawn(worldIn, pos, state, rand);

		    

		}

		  

	}



	@Override

	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {

		

		return true;

		

	}

	

	   

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {

		         

		builder.add(STAGE);

		         	   

	}

	

	public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {

		

		this.grow(worldIn, pos, state, rand);

		

	}

		

}