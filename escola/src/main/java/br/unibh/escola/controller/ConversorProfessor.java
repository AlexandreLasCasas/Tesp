package br.unibh.escola.controller;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.naming.InitialContext;

import br.unibh.escola.data.ServicoProfessor;
import br.unibh.escola.entidades.Professor;

public class ConversorProfessor implements Converter {
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component,
			String value) {
		try {
			ServicoProfessor ss = (ServicoProfessor) new InitialContext()
					.lookup("java:global/escola/ServicoProfessor");
			return ss.find(new Long(value));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component,
			Object value) {
		if (value != null) {
			Professor s = (Professor) value;
			if (s.getId() != null)
				return s.getId().toString();
		}
		return null;
	}
}