package org.scapesoft.api.event.listeners.interfaces;

import org.scapesoft.api.event.EventListener;
import org.scapesoft.game.WorldObject;
import org.scapesoft.game.WorldTile;
import org.scapesoft.game.item.Item;
import org.scapesoft.game.npc.NPC;
import org.scapesoft.game.player.Player;

/**
 * @author Tyluur <itstyluur@gmail.com>
 * @since Apr 21, 2014
 */
public class BankPinListener extends EventListener {

	@Override
	public int[] getEventIds() {
		return new int[] { 759 };
	}

	@Override
	public boolean handleButtonClick(Player player, int interfaceId, int buttonId, int packetId, int slotId, int itemId) {
		Integer i = (Integer) player.getTemporaryAttributtes().get("pin_number_stage");
		int stage = 0;
		if (i == null) {
			player.getTemporaryAttributtes().put("pin_number_stage", 0);
		} else {
			stage = i;
		}
		int pinNumber = buttonId / 4 - 1;
		if (i != null) {
			player.getTemporaryAttributtes().put("pin_number_stage", ++stage);
		}
		player.getBank().getPin().handlePinDigit(stage, pinNumber);
		return true;
	}

	@Override
	public boolean handleObjectClick(Player player, int objectId, WorldObject worldObject, WorldTile tile, ClickOption option) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleNPCClick(Player player, NPC npc, ClickOption option) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleItemClick(Player player, Item item, ClickOption option) {
		// TODO Auto-generated method stub
		return false;
	}

}
