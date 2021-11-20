package xyz.luisch444.carpet.mixin;

import com.google.common.collect.Lists;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.luisch444.carpet.ZickCarpetServer;
import xyz.luisch444.carpet.ZickCarpetSettings;
import xyz.luisch444.carpet.util.Recipes;

import java.io.FileNotFoundException;
import java.util.Map;

@Mixin(RecipeManager.class)
public class RecipeManagerMixin {


    @Inject(method = "apply", at = @At("HEAD"))
    public void interceptApply(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo info) {
        if (ZickCarpetSettings.cryingObsidianCrafteable) {
            JsonObject r = Recipes.createShapedRecipeJson(
                    Lists.newArrayList(
                            '#',
                            'G'
                    ), //The keys we are using for the input items/tags.
                    Lists.newArrayList(new Identifier("obsidian"), new Identifier("ghast_tear")), //The items/tags we are using as input.
                    Lists.newArrayList("item", "item"), //Whether the input we provided is a tag or an item.
                    Lists.newArrayList(
                            "###",
                            "#G#",
                            "###"
                    ), //The crafting pattern.
                    new Identifier("minecraft:crying_obsidian"),8 //The crafting output
            );
            map.put(new Identifier("minecraft", "crying_obsidian"), r);
        }
        if (ZickCarpetSettings.gildedBlackstoneCrafteable) {
            JsonObject r = Recipes.createShapedRecipeJson(
                    Lists.newArrayList(
                            '#',
                            'G'
                    ), //The keys we are using for the input items/tags.
                    Lists.newArrayList(new Identifier("blackstone"), new Identifier("gold_ingot")), //The items/tags we are using as input.
                    Lists.newArrayList("item", "item"), //Whether the input we provided is a tag or an item.
                    Lists.newArrayList(
                            "###",
                            "#G#",
                            "###"
                    ), //The crafting pattern.
                    new Identifier("minecraft:gilded_blackstone"), 8 //The crafting output
            );
            map.put(new Identifier("minecraft", "crying_obsidian"), r);
        }
    }

}
