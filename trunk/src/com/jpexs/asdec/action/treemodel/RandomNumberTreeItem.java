/*
 *  Copyright (C) 2010-2013 JPEXS
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jpexs.asdec.action.treemodel;

import com.jpexs.asdec.action.Action;
import java.util.HashMap; import java.util.List;

public class RandomNumberTreeItem extends TreeItem {

   private TreeItem maximum;

   public RandomNumberTreeItem(Action instruction, TreeItem maximum) {
      super(instruction, PRECEDENCE_PRIMARY);
      this.maximum = maximum;
   }

   @Override
   public String toString(ConstantPool constants) {
      return hilight("random(") + maximum.toString(constants) + hilight(")");
   }
   
   @Override
    public List<com.jpexs.asdec.action.IgnoredPair> getNeededActions() {
      List<com.jpexs.asdec.action.IgnoredPair> ret=super.getNeededActions();
      ret.addAll(maximum.getNeededActions());
      return ret;
   }
}
