
import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Paper from "@material-ui/core/Paper";
import Avatar from "@material-ui/core/Avatar";
import GroupIcon from "@material-ui/icons/Group";
import { Link } from "react-router-dom";
import Typography from "@material-ui/core/Typography";
import CircularProgress from "@material-ui/core/CircularProgress";

export default function AccountList() {

    const [data, upDateDate] = React.useState([]);
    const [firstLoad, setLoad] = React.useState(true);
    let isLoading = true;

    async function getAccounts() {
        let response = await fetch("api/account/get-all");
        let body = await response.json();
        upDateDate(body.object)
    }

    if (firstLoad) {
        getAccounts();
        setLoad(false);
    }

    if (data.length > 0) isLoading = false;
    
    return (
        <div className={classes.paper}>
        <Avatar className={classes.avatar}>
            <GroupIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
            Account Directory
        </Typography>

        {isLoading ? (
            <CircularProgress />
        ) : (
            <TableContainer
            style={{ width: "80%", margin: "0 10px" }}
            component={Paper}
            >
            <Table className={classes.table} aria-label="simple table">
                <TableHead>
                <TableRow>
                    <TableCell align="center">Email</TableCell>
                    <TableCell align="center">Name</TableCell>
                    <TableCell align="center">Income</TableCell>
                    <TableCell align="center">Saving</TableCell>
                    <TableCell align="center">Net Saving</TableCell>
                    <TableCell align="center">Debt</TableCell>
                </TableRow>
                </TableHead>
                <TableBody>
                {data?.map(row => (
                    <TableRow key={row.Email}>
                    <TableCell align="center">{row.email}</TableCell>
                    <TableCell align="center">{row.name}</TableCell>
                    <TableCell align="center">{row.income}</TableCell>
                    <TableCell align="center">{row.saving}</TableCell>
                    </TableRow>
                ))}
                </TableBody>
            </Table>
            </TableContainer>
        )}
        <Link className={classes.link} to="/">
            {" "}
            <Typography align="left">
            &#x2190; Head back to save data
            </Typography>{" "}
        </Link>
        </div>    
    );
}