<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Indian</title>
</head>
<body>
	<h1>Indian</h1>
	<p>Screen for Indian Pizza Order</p>

	<form:form method="POST" action="/PizzaOrder/Orderindian">
		<table>
			<tr>
				<td><select name="Crust">
						<option value="Fresh Pan">Fresh Pan</option>
						<option value="Thin">Thin</option>
						<option value="Cheese brust">Cheese brust</option>
				</select></td>
			</tr>
			<br>
			<br>
			<tr>
				<input type="checkbox" name="toppingstype" value="Red pepper">Red pepper
				<br>
				<input type="checkbox" name="toppingstype" value="Paneer">Paneer
				<br>
				<input type="checkbox" name="toppingstype" value="Olives">Olives
				<br>
			</tr>
			<br>
			<br>
			<tr>
				<td><select name="quantity">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Calculate Price" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>