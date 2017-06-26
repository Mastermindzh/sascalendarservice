package parser

/**
  * Created by Wilko on 11/05/2017.
  */

import ast.{Stylesheet, _}
import antlr.summary.{SummaryBaseListener, SummaryParser}


class SummaryASTListener extends SummaryBaseListener {
  var ast: AST = new AST
  var stack: List[ASTNode] = Nil

  override def enterStylesheet(ctx: SummaryParser.StylesheetContext): Unit = {
    super.enterStylesheet(ctx)
    val node: Stylesheet = new Stylesheet
    ast.setRoot(node)
  }

  override def exitStylesheet(ctx: SummaryParser.StylesheetContext): Unit = {
    super.exitStylesheet(ctx)
  }

  override def enterSemester(ctx: SummaryParser.SemesterContext): Unit = {
    super.enterSemester(ctx)
    if (!ctx.children.isEmpty) {
      val node: Value = new Value
      node.valueName = "semester"
      node.value = ctx.children.get(0).toString
      ast.root.addChild(node)
    }
  }

  override def exitSemester(ctx: SummaryParser.SemesterContext): Unit = {
    super.exitSemester(ctx)
  }

  override def enterSubject(ctx: SummaryParser.SubjectContext): Unit = {
    super.enterSubject(ctx)
    if (Option(ctx.children).isDefined && !ctx.children.isEmpty) {
      val node: Value = new Value
      node.valueName = "subject"
      node.value = ctx.children.get(0).toString
      ast.root.addChild(node)
    }
  }

  override def exitSubject(ctx: SummaryParser.SubjectContext): Unit = {
    super.exitSubject(ctx)
  }

  override def enterClassname(ctx: SummaryParser.ClassnameContext): Unit = {
    super.enterClassname(ctx)
    if (Option(ctx.children).isDefined && !ctx.children.isEmpty) {
      val node: Value = new Value
      node.valueName = "classname"
      node.value = ctx.children.get(0).toString
      ast.root.addChild(node)
    }
  }

  override def exitClassname(ctx: SummaryParser.ClassnameContext): Unit = {
    super.exitClassname(ctx)
  }

  override def enterTeachers(ctx: SummaryParser.TeachersContext): Unit = {
    super.enterTeachers(ctx)
    if (Option(ctx.children).isDefined && !ctx.children.isEmpty) {

      val node: Teachers = new Teachers
      ast.root.addChild(node)
      stack = stack ++ List(node)
    }
  }

  override def exitTeachers(ctx: SummaryParser.TeachersContext): Unit = {
    super.exitTeachers(ctx)
    stack = stack.dropRight(1)
  }

  override def enterTeacher(ctx: SummaryParser.TeacherContext): Unit = {
    super.enterTeacher(ctx)
    if (Option(ctx.children).isDefined && !ctx.children.isEmpty) {

      val teacher: Teacher = new Teacher
      teacher.name = ctx.children.get(0).toString
      stack = stack ++ List(teacher)
    }
  }

  override def exitTeacher(ctx: SummaryParser.TeacherContext): Unit = {
    super.exitTeacher(ctx)

    val teacher: Teacher = stack.last.asInstanceOf[Teacher]
    stack = stack.dropRight(1)
    val teachers: Teachers = stack.last.asInstanceOf[Teachers]
    teachers.addChild(teacher)
  }

  override def enterAbbreviation(ctx: SummaryParser.AbbreviationContext): Unit = {
    super.enterAbbreviation(ctx)
    if (Option(ctx.children).isDefined && !ctx.children.isEmpty) {

      val teacher: Teacher = stack.last.asInstanceOf[Teacher]
      teacher.abbreviation = ctx.children.get(0).toString
    }
  }

  override def exitAbbreviation(ctx: SummaryParser.AbbreviationContext): Unit = {
    super.exitAbbreviation(ctx)
  }
}
