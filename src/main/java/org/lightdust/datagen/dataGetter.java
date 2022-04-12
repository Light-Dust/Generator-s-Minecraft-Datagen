package org.lightdust.datagen;

import net.fabricmc.api.ModInitializer;
//下面到org前都是后来加进去的
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class dataGetter implements ModInitializer {
	public static boolean loaded;
	// 物品注册
	public static final Item FABRIC_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MISC));

	// 这个记录器用于将文本写入控制台和日志文件。
	// 最好的做法是使用你的mod id作为日志记录器的名称。
	// 这样，就很清楚哪个mod写了信息、警告和错误。
	public static final Logger LOGGER = LoggerFactory.getLogger("data_getter");

	@Override
	public void onInitialize() {
		// 当Minecraft处于mod加载就绪状态时，这段代码就会运行。
		// 然而，有些东西(比如资源)可能仍然没有初始化。
		// 谨慎行事。
		if (!loaded) {
			register.run();
			loaded = true;
		}
	}
}

