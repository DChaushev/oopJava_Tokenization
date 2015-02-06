# oopJava_Tokenization
Project that I'm making for elective course "OOP with Java" at the university.

Descripton:
-----------
Tokenization of bank cards with RMI and graphical interface.

Must implement tokenization that from given card number returns a token.<br/>
For example:<br/>
Card No.: 4563960122019991<br/>
Token: 1234243434269991<br/>

<b>These are the requerements for the token:</b>
<ul>
<li>The number of digits of the card number must be equal to the number of digits of the token.</li>
<li>The last four digits of the token must be the same as the last four digits of the card number.</li>
<li>The first twelve number of the token must be randomly generated and must NOT match the corresponding ones on the card number.</li>
<li>The first number of the token must be different from {3, 4, 5, 6}, which are used by the major bank cards brands.</li>
<li>The sum of the digits of the token should nоt be a multiple of 10.</li>
</ul>

<b>The system must implement client access control:</b>
<ul>
<li>Token registration: The client gives his card number. It is validated with the Luhn's algorithm. If the number is valid the client receives the token. If not - he gets the corresponding error message.</li>
<li>The client can see his card number with the token. Error if no such token is registered.</li>
</ul>

<b>The server must implement RMI application with GUI:</b>
<ul>
<li>Conservation card number <=> token relationships in XML serialization.</li>
<li>Conservation of clients information (username and password) and their rights in XML serialization.</li>
<li>The new registered token must be unique among all created ones. The server must implement the token registration logic.</li>
<li>Before using the system, the client must log with his username and password. Error if not valid.</li>
<li> If the clien tries to use functionality without having the permissions for it(tokenization to card number and vice versa) he receives error.</li>
<li>Exporting to text file all registered tokens with their coresponding card number, sorted by the token/card_number (one bank card can have multiple tokens).</li>
</ul>

<b>The client GUI must provide the following interface:</b>
<ul>
<li><del>Open socket to the server,</del> sending the username and password (Swing interface).</li>
<li>Options for registering token and receiving the card number by given token.</li>
<li>Correctly visualize results and errors.</li>
<li>The user input must be validated with regular expressions.</li>
</ul>
