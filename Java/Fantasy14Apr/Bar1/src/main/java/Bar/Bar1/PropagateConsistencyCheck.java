/*
 * Sonar ESQL Plugin
 * Copyright (C) 2013-2017 Thomas Pohl and EXXETA AG
 * http://www.exxeta.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.exxeta.iss.sonar.esql.check;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.sonar.check.Rule;

import com.exxeta.iss.sonar.esql.api.tree.Tree.Kind;
import com.exxeta.iss.sonar.esql.api.tree.statement.BeginEndStatementTree;
import com.exxeta.iss.sonar.esql.api.tree.statement.CreateFunctionStatementTree;
import com.exxeta.iss.sonar.esql.api.tree.statement.CreateModuleStatementTree;
import com.exxeta.iss.sonar.esql.api.tree.statement.CreateProcedureStatementTree;
import com.exxeta.iss.sonar.esql.api.tree.statement.PropagateStatementTree;
import com.exxeta.iss.sonar.esql.api.tree.statement.ReturnStatementTree;
import com.exxeta.iss.sonar.esql.api.tree.statement.StatementTree;
import com.exxeta.iss.sonar.esql.api.tree.statement.StatementsTree;
import com.exxeta.iss.sonar.esql.api.visitors.DoubleDispatchVisitorCheck;
import com.exxeta.iss.sonar.esql.api.visitors.EsqlFile;
import com.exxeta.iss.sonar.esql.api.visitors.IssueLocation;
import com.exxeta.iss.sonar.esql.api.visitors.PreciseIssue;

@Rule(key = "PropagateConsistency")
public class PropagateConsistencyCheck extends DoubleDispatchVisitorCheck {

	private static final String MESSAGE = "Compute node connections are inconsistent";

	// @Override
	// public void visitPropagateStatement(PropagateStatementTree tree) {
	// super.visitPropagateStatement(tree);
	// System.out.println(tree.target().toString());
	// }

//	@Override
//	public void visitCreateFunctionStatement(CreateFunctionStatementTree tree) {
//		if ("Main".equalsIgnoreCase(tree.identifier().name())
//				&& tree.routineBody().statement().is(Kind.BEGIN_END_STATEMENT)) {
//			BeginEndStatementTree beginEnd = (BeginEndStatementTree) tree.routineBody().statement();
//			StatementsTree statements = beginEnd.statements();
//			int nos = statements.statements().size();
//			for (int i = 0; i < nos; i++) {
//				if (statements.statements().get(0).is(Kind.PROPAGATE_STATEMENT)) {
//					PropagateStatementTree propagateStatement = (PropagateStatementTree) statements.statements().get(i);
//					if ("TERMINAL".equalsIgnoreCase(propagateStatement.targetType().text())) {
//						EsqlFile file = getContext().getEsqlFile();
//						String path = file.relativePath();
//						path = path.substring(0, path.lastIndexOf("\\")-1);
//						System.out.println(path);
////						addIssue(tree, "The compute node connections are inconsistent.");
//					}
//				}
//
//			}
//		}
//	}
//	
//	@Override
//	public void visitCreateProcedureStatement(CreateProcedureStatementTree tree) {
//		if (tree.routineBody().statement().is(Kind.BEGIN_END_STATEMENT)) {
//			BeginEndStatementTree beginEnd = (BeginEndStatementTree) tree.routineBody().statement();
//			StatementsTree statements = beginEnd.statements();
//			int nos = statements.statements().size();
//			for (int i = 0; i < nos; i++) {
//				if (statements.statements().get(0).is(Kind.PROPAGATE_STATEMENT)) {
//					PropagateStatementTree propagateStatement = (PropagateStatementTree) statements.statements().get(i);
//					if ("TERMINAL".equalsIgnoreCase(propagateStatement.targetType().text())) {
//						EsqlFile file = getContext().getEsqlFile();
//						String path = file.relativePath();
//						path = path.substring(0, path.lastIndexOf("/"));
//						File projectFile = new File(path);
//						File[] files = projectFile.listFiles();
//						ArrayList<File> fileList = getMsgFlowFiles(files);
//						
////						addIssue(tree, "The compute node connections are inconsistent.");
//					}
//				}
//
//			}
//		}
//	}
	
	@Override
	public void visitCreateModuleStatement(CreateModuleStatementTree tree) {
		super.visitCreateModuleStatement(tree);
		System.out.println(tree.moduleName().name());
		List<StatementTree> statementList = tree.moduleStatementsList();
		for(StatementTree stat : statementList) {
			System.out.println(stat);
			if (stat.is(Kind.PROPAGATE_STATEMENT)) {
				PropagateStatementTree propagateStatement = (PropagateStatementTree) stat;
				if ("TERMINAL".equalsIgnoreCase(propagateStatement.targetType().text())) {
					System.out.println(propagateStatement.target().toString());
				}
			}
			
		}
	}
	
	
	
	public static ArrayList<File> getMsgFlowFiles(File[] files){
		ArrayList<File> fileList = new ArrayList<File>();
		for(File tmpFile : files) {
			if(tmpFile.isDirectory()) {
				fileList.addAll(getMsgFlowFiles(tmpFile.listFiles()));
			}
			else {
				if(tmpFile.getAbsolutePath().endsWith(".msgflow")) {
					fileList.add(tmpFile);
				}
			}
		}
		return fileList;
	}
}
