package com.shan.org.shan.sxs.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shan.org.shan.sxs.dao.TreeDao;
import com.shan.org.shan.sxs.pojo.Tree;
import com.shan.org.shan.sxs.pojo.TreeQuery;
import com.shan.org.shan.sxs.port.ShannengliangPort;
import com.shan.org.shan.sxs.port.shannenegliang.Baseshannenegliang;
import com.shan.org.shan.sxs.service.TreeService;
import com.shan.org.shan.sxs.utils.BatchDateUtil;

import net.sf.json.JSONObject;

@Service
@Transactional
public class TreeServiceImpl implements TreeService{

	@Autowired
	private TreeDao treeDao;

	@Override
	public Tree insert(Long userId) {
		Tree tree = new Tree();
		tree.setCreateTime(BatchDateUtil.getBatch(new Date()));
		String shannengliang = ShannengliangPort.shannengliang(userId.toString());
		JSONObject fromObject = JSONObject.fromObject(shannengliang);
		Baseshannenegliang  bean = (Baseshannenegliang) JSONObject.toBean(fromObject, Baseshannenegliang.class);
		String num = bean.getData().getData().getNum();
		tree.setEnergy(Long.parseLong(num));
		tree.setUserId(userId);
		tree.setAge();
		treeDao.insertSelective(tree);
		TreeQuery treeQuery = new TreeQuery();
		treeQuery.createCriteria().andUserIdEqualTo(userId);
		return treeDao.selectByExample(treeQuery).get(0);
	}
}