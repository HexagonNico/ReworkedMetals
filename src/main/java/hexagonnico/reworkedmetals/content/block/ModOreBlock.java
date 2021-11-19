package hexagonnico.reworkedmetals.content.block;

import java.util.Random;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

/**
 * Class for modded ores since xp drop is hardcoded in 1.16.
 * 
 * @author Nico
 */
public class ModOreBlock extends OreBlock {
    
    private final int minExp;
    private final int maxExp;
    
    /**
     * Creates block with properties.
     * @param properties AbstractBlock.Properties.of(...
     */
    public ModOreBlock(Properties properties) {
        this(properties, 0, 0);
    }
    
    /**
     * Creates block with properties and xp drop.
     * @param properties AbstractBlock.Properties.of(...
     * @param minExp Minimum xp drop
     * @param maxExp Maximum xp drop
     */
    public ModOreBlock(Properties properties, int minExp, int maxExp) {
        super(properties);
        this.minExp = minExp;
        this.maxExp = maxExp;
    }
    
    @Override // Drop xp when destroyed
    protected int xpOnDrop(Random random) {
        if(this.minExp != 0 && this.maxExp != 0)
            return MathHelper.nextInt(random, this.minExp, this.maxExp);
        else
            return super.xpOnDrop(random);
    }
}
