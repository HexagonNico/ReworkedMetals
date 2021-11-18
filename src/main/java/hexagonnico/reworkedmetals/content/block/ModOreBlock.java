package hexagonnico.reworkedmetals.content.block;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

@ParametersAreNonnullByDefault
public class ModOreBlock extends OreBlock {
    
    private final int minExp;
    private final int maxExp;
    
    public ModOreBlock(Properties properties) {
        this(properties, 0, 0);
    }
    
    public ModOreBlock(Properties properties, int minExp, int maxExp) {
        super(properties);
        this.minExp = minExp;
        this.maxExp = maxExp;
    }
    
    @Override
    protected int xpOnDrop(Random random) {
        if(this.minExp != 0 && this.maxExp != 0)
            return MathHelper.nextInt(random, this.minExp, this.maxExp);
        else
            return super.xpOnDrop(random);
    }
}
