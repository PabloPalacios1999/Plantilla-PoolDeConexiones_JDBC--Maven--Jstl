package com.ecodeap.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecodeap.dao.ProductoDAO;
import com.ecodeap.model.Producto;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet(description = "administra peticiones para la tabla productos", urlPatterns = { "/ProductoController" })
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductoDAO productoDao = new ProductoDAO();
		String op = request.getParameter("option");
		RequestDispatcher rd;
		
		switch (op) {
		case "crear":
			//System.out.println("usted ha precionado opcion crear");
			rd = request.getRequestDispatcher("/views/crear.jsp");
			rd.forward(request, response);
			break;
		case "editar":
			//System.out.println("usted ha precionado opcion editar");
			rd = request.getRequestDispatcher("/views/editar.jsp");
			rd.forward(request, response);
			break;
		case "meditar":
			int id = Integer.parseInt(request.getParameter("idEditar"));
			System.out.println(id);
			Producto p = new Producto();
			try {
				p = productoDao.obtenerProducto(id);
				System.out.println(p);
				request.setAttribute("producto", p);
				rd = request.getRequestDispatcher("/views/editar.jsp");
				rd.forward(request, response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			break;
		case "meliminar":
			int id2 = Integer.parseInt(request.getParameter("idEliminar"));
			try {
				productoDao.eliminar(id2);
				System.out.println("pRODUCTO ELIMINADO");
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			break;
		case "listar":
			//System.out.println("usted ha precionado opcion listar");
			
			List<Producto> lista  = new ArrayList<>();
			
			try {
				lista = productoDao.obtenerProductos();
				for (Producto producto: lista) {
					System.out.println(producto);
				}
				request.setAttribute("lista", lista);
				rd = request.getRequestDispatcher("/views/listar.jsp");
				rd.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			break;

		default:
			System.out.println("por defecto");
			break;
		}
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		ProductoDAO productoDao = new ProductoDAO();
		Producto producto = new Producto();
		Producto producto2 = new Producto();
		Date fechaActual = new Date();
		RequestDispatcher rd;
		String opcion = request.getParameter("option");
		
		switch (opcion) {
			case "guardar":
				producto.setNombre(request.getParameter("nombreProducto"));
				producto.setCantidad(Double.parseDouble(request.getParameter("cantidadProducto")));
				producto.setPrecio(Double.parseDouble(request.getParameter("precioProducto")));
				producto.setFechaCrear(new java.sql.Date(fechaActual.getTime()));
				producto.setFechaActualizar(new java.sql.Date(fechaActual.getTime()));
				
				try {
					if(productoDao.guardar(producto)) {
						System.out.println("Producto registrado");
						rd = request.getRequestDispatcher("/views/crear.jsp");
						rd.forward(request, response);
					}else {
						System.out.println("El producto no ha sido registrado");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case "editar":
				producto2.setId(Integer.parseInt(request.getParameter("idEditar")));
				producto2.setNombre(request.getParameter("nombreProductoE"));
				producto2.setCantidad(Double.parseDouble(request.getParameter("cantidadProductoE")));
				producto2.setPrecio(Double.parseDouble(request.getParameter("precioProductoE")));
				producto2.setFechaActualizar(new java.sql.Date(fechaActual.getTime()));
			try {
				if(productoDao.editar(producto2)) {
					System.out.println("Producto editado");
					rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}else {
					System.out.println("El producto no ha sido editado");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			default:
				System.out.println("Default");
				break;
			}
		
		
		

	}

}
