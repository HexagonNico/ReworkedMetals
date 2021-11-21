package hexagonnico.reworkedmetals.content.world;

/**
 * Placement configuration for ore generation.
 * Generates ore within a range and a number of attempts.
 * 
 * @author Nico
 */
public class OreRangePlacement {

    // private final int minAttempts;
    // private final int maxAttempts;
    // private final int minHeight;
    // private final int maxHeight;

    // /**
    //  * Create range placement
    //  * @param minAttempts Min number of attempts per chunk
    //  * @param maxAttempts Max number of attempts per chunk
    //  * @param minHeight Min height value
    //  * @param maxHeight Max height value
    //  */
    // public OreRangePlacement(int minAttempts, int maxAttempts, int minHeight, int maxHeight) {
    //     super(NoPlacementConfig.CODEC);
    //     this.minAttempts = minAttempts;
    //     this.maxAttempts = maxAttempts;
    //     this.minHeight = minHeight;
    //     this.maxHeight = maxHeight;
    // }

    // @Override // Place at position
    // protected Stream<BlockPos> place(Random random, NoPlacementConfig config, BlockPos pos) {
    //     int attempts = this.minAttempts + random.nextInt(this.maxAttempts - this.minAttempts + 1);
    //     return IntStream.range(0, attempts).mapToObj(i -> {
    //         int x = pos.getX() + random.nextInt(16);
    //         int y = this.minHeight + random.nextInt(this.maxHeight - this.minHeight + 1);
    //         int z = pos.getZ() + random.nextInt(16);
    //         return new BlockPos(x, y, z);
    //     });
    // }
    
}
