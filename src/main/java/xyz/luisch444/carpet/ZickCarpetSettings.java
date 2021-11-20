package xyz.luisch444.carpet;

import carpet.settings.ParsedRule;
import carpet.settings.Rule;
import carpet.settings.Validator;
import net.minecraft.server.command.ServerCommandSource;

import java.util.Arrays;

import static carpet.settings.RuleCategory.*;

public class ZickCarpetSettings {
    public static final String ZICK = "ZickCarpet";
    public static final String EpsilonCarpetSettingsCategory = "epsilon-carpet";

    @Rule(desc = "DeepSlate have the same hardness that stone", category = { ZICK, SURVIVAL})
    public static boolean deepSlateInstaminable = false;

    @Rule(desc = "EndStone have the same hardness that stone", category = { ZICK, SURVIVAL})
    public static boolean EndStonelessHardness = false;

    @Rule(desc = "You can craft crying obsidian with a ghast tear rounded by obsidian (you need to do /reload or close and open the world to toggle it)", category = { ZICK, SURVIVAL})
    public static boolean cryingObsidianCrafteable = false;

    @Rule(desc = "You can craft gilded blackstone with a gold ingot rounded by blackstone (you need to do /reload or close and open the world to toggle it)", category = { ZICK, SURVIVAL})
    public static boolean gildedBlackstoneCrafteable = false;

    //part of epsilon carpet https://github.com/EpsilonSMP/Epsilon-Carpet
        private static final String[] carefulBreakOptions = new String[] { "never", "always", "sneaking", "no-sneaking" };
    @Rule(
            desc = "Places the mined block in the player inventory when sneaking.",
            category = { EpsilonCarpetSettingsCategory, SURVIVAL, FEATURE, EXPERIMENTAL, ZICK },
            options = { "never", "always", "sneaking", "no-sneaking" },
            validate = { carefulBreakValidator.class }
    )
    public static String carefulBreak = "never";

    private static class carefulBreakValidator extends Validator<String> {

        @Override
        public String validate(ServerCommandSource serverCommandSource, ParsedRule<String> parsedRule, String s, String s2) {
            if ((serverCommandSource == null || parsedRule.get().equals(s)) && Arrays.asList(carefulBreakOptions).contains(s))
                carefulBreak = s;
            return s;
        }
    }
    //finish of epsilon carpet https://github.com/EpsilonSMP/Epsilon-Carpet

}
