package io.neow3j.protocol.core;

import io.neow3j.contract.ContractParameter;
import io.neow3j.contract.ScriptHash;
import io.neow3j.protocol.Neow3j;
import io.neow3j.protocol.RequestTester;
import io.neow3j.protocol.core.methods.response.TransactionSendAsset;
import io.neow3j.protocol.http.HttpService;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

public class RequestTest extends RequestTester {

    private Neow3j neow3j;

    @Override
    protected void initWeb3Client(HttpService httpService) {
        neow3j = Neow3j.build(httpService);
    }

    // Blockchain Methods

    @Test
    public void testGetBestBlockHash() throws Exception {
        neow3j.getBestBlockHash().send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getbestblockhash\",\"params\":[],\"id\":1}");
    }

    @Test
    public void testGetBlockHash() throws Exception {
        neow3j.getBlockHash(new BlockParameterIndex(16293)).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getblockhash\","
                        + "\"params\":[16293],\"id\":1}");
    }

    @Test
    public void testGetBlock_Index() throws Exception {
        neow3j.getBlock(new BlockParameterIndex(12345), true).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getblock\","
                        + "\"params\":[12345,1],\"id\":1}");
    }

    @Test
    public void testGetBlock_Hash() throws Exception {
        neow3j.getBlock("0x2240b34669038f82ac492150d391dfc3d7fe5e3c1d34e5b547d50e99c09b468d", true).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getblock\","
                        + "\"params\":[\"0x2240b34669038f82ac492150d391dfc3d7fe5e3c1d34e5b547d50e99c09b468d\",1],\"id\":1}");
    }

    @Test
    public void testGetRawBlock_Index() throws Exception {
        neow3j.getRawBlock(new BlockParameterIndex(12345)).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getblock\","
                        + "\"params\":[12345,0],\"id\":1}");
    }

    @Test
    public void testGetRawBlock_Hash() throws Exception {
        neow3j.getRawBlock("0x2240b34669038f82ac492150d391dfc3d7fe5e3c1d34e5b547d50e99c09b468d").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getblock\","
                        + "\"params\":[\"0x2240b34669038f82ac492150d391dfc3d7fe5e3c1d34e5b547d50e99c09b468d\",0],\"id\":1}");
    }

    @Test
    public void testGetBlockCount() throws Exception {
        neow3j.getBlockCount().send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getblockcount\","
                        + "\"params\":[],\"id\":1}");
    }

    @Test
    public void testGetBlockHeader_Hash() throws Exception {
        neow3j.getBlockHeader("0x2240b34669038f82ac492150d391dfc3d7fe5e3c1d34e5b547d50e99c09b468d").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getblockheader\","
                        + "\"params\":[\"0x2240b34669038f82ac492150d391dfc3d7fe5e3c1d34e5b547d50e99c09b468d\",1],\"id\":1}");
    }

    @Test
    public void testGetBlockHeader_Index() throws Exception {
        neow3j.getBlockHeader(new BlockParameterIndex(12345)).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getblockheader\","
                        + "\"params\":[12345,1],\"id\":1}");
    }

    @Test
    public void testGetRawBlockHeader_Hash() throws Exception {
        neow3j.getRawBlockHeader("0x2240b34669038f82ac492150d391dfc3d7fe5e3c1d34e5b547d50e99c09b468d").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getblockheader\","
                        + "\"params\":[\"0x2240b34669038f82ac492150d391dfc3d7fe5e3c1d34e5b547d50e99c09b468d\",0],\"id\":1}");
    }

    @Test
    public void testGetRawBlockHeader_Index() throws Exception {
        neow3j.getRawBlockHeader(new BlockParameterIndex(12345)).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getblockheader\","
                        + "\"params\":[12345,0],\"id\":1}");
    }

    @Test
    public void testGetContractState() throws Exception {
        neow3j.getContractState("dc675afc61a7c0f7b3d2682bf6e1d8ed865a0e5f").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getcontractstate\","
                        + "\"params\":[\"dc675afc61a7c0f7b3d2682bf6e1d8ed865a0e5f\"],\"id\":1}"
        );
    }

    @Test
    public void testGetMemPool() throws Exception {
        neow3j.getMemPool().send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getrawmempool\","
                        + "\"params\":[1],\"id\":1}");
    }

    @Test
    public void testGetRawMemPool() throws Exception {
        neow3j.getRawMemPool().send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getrawmempool\","
                        + "\"params\":[],\"id\":1}");
    }

    @Test
    public void testGetTransaction() throws Exception {
        neow3j.getTransaction("0x1f31821787b0a53df0ff7d6e0e7ecba3ac19dd517d6d2ea5aaf00432c20831d6").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getrawtransaction\","
                        + "\"params\":[\"0x1f31821787b0a53df0ff7d6e0e7ecba3ac19dd517d6d2ea5aaf00432c20831d6\",1],\"id\":1}");
    }

    @Test
    public void testGetRawTransaction() throws Exception {
        neow3j.getRawTransaction("0x1f31821787b0a53df0ff7d6e0e7ecba3ac19dd517d6d2ea5aaf00432c20831d6").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getrawtransaction\","
                        + "\"params\":[\"0x1f31821787b0a53df0ff7d6e0e7ecba3ac19dd517d6d2ea5aaf00432c20831d6\",0],\"id\":1}");
    }

    @Test
    public void testGetStorage() throws Exception {
        neow3j.getStorage("03febccf81ac85e3d795bc5cbd4e84e907812aa3", "616e797468696e67").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getstorage\","
                        + "\"params\":[\"03febccf81ac85e3d795bc5cbd4e84e907812aa3\",\"616e797468696e67\"],\"id\":1}");
    }

    @Test
    public void testGetStorage_with_HexParameter() throws Exception {
        neow3j.getStorage("03febccf81ac85e3d795bc5cbd4e84e907812aa3", HexParameter.valueOf("anything")).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getstorage\","
                        + "\"params\":[\"03febccf81ac85e3d795bc5cbd4e84e907812aa3\",\"616e797468696e67\"],\"id\":1}");
    }

    @Test
    public void testGetTransactionHeight() throws Exception {
        neow3j.getTransactionHeight("0x793f560ae7058a50c672890e69c9292391dd159ce963a33462059d03b9573d6a").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"gettransactionheight\","
                        + "\"params\":[\"0x793f560ae7058a50c672890e69c9292391dd159ce963a33462059d03b9573d6a\"],\"id\":1}");
    }

    @Test
    public void testGetValidators() throws Exception {
        neow3j.getValidators().send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getvalidators\","
                        + "\"params\":[],\"id\":1}");
    }

    // Node Methods

    @Test
    public void testGetConnectionCount() throws Exception {
        neow3j.getConnectionCount().send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getconnectioncount\","
                        + "\"params\":[],\"id\":1}");
    }

    @Test
    public void testGetPeers() throws Exception {
        neow3j.getPeers().send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getpeers\","
                        + "\"params\":[],\"id\":1}");
    }

    @Test
    public void testGetVersion() throws Exception {
        neow3j.getVersion().send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getversion\",\"params\":[],\"id\":1}");
    }

    @Test
    public void testSendRawTransaction() throws Exception {
        neow3j.sendRawTransaction("80000001d405ab03e736a01ca277d94b1377113c7e961bb4550511fe1d408f30c77a82650000029b7cffdaa674beae0f930ebe6085af9093e5fe56b34a5c220ccdcf6efc336fc500ca9a3b0000000023ba2703c53263e8d6e522dc32203339dcd8eee99b7cffdaa674beae0f930ebe6085af9093e5fe56b34a5c220ccdcf6efc336fc5001a711802000000295f83f83fc439f56e6e1fb062d89c6f538263d70141403711e366fc99e77a110b6c96b5f8828ef956a6d5cfa5cb63273419149011b0f30dc5458faa59e4867d0ac7537e324c98124bb691feca5c5ddf6ed20f4adb778223210265bf906bf385fbf3f777832e55a87991bcfbe19b097fb7c5ca2e4025a4d5e5d6ac").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"sendrawtransaction\","
                        + "\"params\":[\"80000001d405ab03e736a01ca277d94b1377113c7e961bb4550511fe1d408f30c77a82650000029b7cffdaa674beae0f930ebe6085af9093e5fe56b34a5c220ccdcf6efc336fc500ca9a3b0000000023ba2703c53263e8d6e522dc32203339dcd8eee99b7cffdaa674beae0f930ebe6085af9093e5fe56b34a5c220ccdcf6efc336fc5001a711802000000295f83f83fc439f56e6e1fb062d89c6f538263d70141403711e366fc99e77a110b6c96b5f8828ef956a6d5cfa5cb63273419149011b0f30dc5458faa59e4867d0ac7537e324c98124bb691feca5c5ddf6ed20f4adb778223210265bf906bf385fbf3f777832e55a87991bcfbe19b097fb7c5ca2e4025a4d5e5d6ac\"],\"id\":1}");
    }

    @Test
    public void testSubmitBlock() throws Exception {
        neow3j.submitBlock("00000000000000000000000000000000").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"submitblock\","
                        + "\"params\":[\"00000000000000000000000000000000\"],\"id\":1}"
        );
    }

    // SmartContract Methods

    @Test
    public void testInvokeFunction() throws Exception {
        neow3j.invokeFunction(
                "af7c7328eee5a275a3bcaee2bf0cf662b5e739be",
                "balanceOf",
                Arrays.asList(
                        ContractParameter.hash160(new ScriptHash("91b83e96f2a7c4fdf0c1688441ec61986c7cae26"))
                ),
                "0xcadb3dc2faa3ef14a13b619c9a43124755aa2569"
        ).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"invokefunction\","
                        + "\"params\":[\"af7c7328eee5a275a3bcaee2bf0cf662b5e739be\","
                        + "\"balanceOf\","
                        + "["
                        + "{\"type\":\"Hash160\",\"value\":\"91b83e96f2a7c4fdf0c1688441ec61986c7cae26\"}"
                        + "],"
                        + "[\"0xcadb3dc2faa3ef14a13b619c9a43124755aa2569\"]"
                        + "],\"id\":1}"
        );
    }

    @Test
    public void testInvokeFunction_without_Params() throws Exception {
        neow3j.invokeFunction(
                "af7c7328eee5a275a3bcaee2bf0cf662b5e739be",
                "decimals"
        ).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"invokefunction\","
                        + "\"params\":[\"af7c7328eee5a275a3bcaee2bf0cf662b5e739be\","
                        + "\"decimals\""
                        + "],\"id\":1}"
        );
    }

    @Test
    public void testInvokeScript() throws Exception {
        neow3j.invokeScript("00046e616d656724058e5e1b6008847cd662728549088a9ee82191").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"invokescript\","
                        + "\"params\":[\"00046e616d656724058e5e1b6008847cd662728549088a9ee82191\"],"
                        + "\"id\":1}"
        );
    }

    @Test
    public void testInvokeScriptWithWitness() throws Exception {
        neow3j.invokeScript("00046e616d656724058e5e1b6008847cd662728549088a9ee82191",
                "0xcadb3dc2faa3ef14a13b619c9a43124755aa2569").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"invokescript\","
                        + "\"params\":["
                        +       "\"00046e616d656724058e5e1b6008847cd662728549088a9ee82191\","
                        +       "[\"0xcadb3dc2faa3ef14a13b619c9a43124755aa2569\"]"
                        + "],\"id\":1}"
        );
    }

    // Utilities Methods

    @Test
    public void testListPlugins() throws Exception {
        neow3j.listPlugins().send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"listplugins\",\"params\":[],\"id\":1}"
        );
    }

    @Test
    public void testValidateAddress() throws Exception {
        neow3j.validateAddress("AQVh2pG732YvtNaxEGkQUei3YA4cvo7d2i").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"validateaddress\","
                        + "\"params\":[\"AQVh2pG732YvtNaxEGkQUei3YA4cvo7d2i\"],\"id\":1}");
    }

    // Wallet Methods

    @Test
    public void testCloseWallet() throws Exception {
        neow3j.closeWallet().send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"closewallet\","
                        + "\"params\":[],\"id\":1}");
    }

    @Test
    public void testOpenWallet() throws Exception {
        neow3j.openWallet("wallet.json", "one").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"openwallet\","
                        + "\"params\":[\"wallet.json\",\"one\"],\"id\":1}");
    }

    @Test
    public void testDumpPrivKey() throws Exception {
        neow3j.dumpPrivKey("AHE5cLhX5NjGB5R2PcdUvGudUoGUBDeHX4").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"dumpprivkey\","
                        + "\"params\":[\"AHE5cLhX5NjGB5R2PcdUvGudUoGUBDeHX4\"],\"id\":1}");
    }

    @Test
    public void testGetBalance() throws Exception {
        neow3j.getBalance("9bde8f209c88dd0e7ca3bf0af0f476cdd8207789").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getbalance\","
                        + "\"params\":[\"9bde8f209c88dd0e7ca3bf0af0f476cdd8207789\"],\"id\":1}");
    }

    @Test
    public void testGetBalance_with_Prefix() throws Exception {
        neow3j.getBalance("0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getbalance\","
                        + "\"params\":[\"9bde8f209c88dd0e7ca3bf0af0f476cdd8207789\"],\"id\":1}");
    }

    @Test
    public void testGetNewAddress() throws Exception {
        neow3j.getNewAddress().send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getnewaddress\","
                        + "\"params\":[],\"id\":1}");
    }

    @Test
    public void testGetUnclaimedGas() throws Exception {
        neow3j.getUnclaimedGas().send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getunclaimedgas\","
                        + "\"params\":[],\"id\":1}");
    }

    @Test
    public void testImportPrivKey() throws Exception {
        neow3j.importPrivKey("L5c6jz6Rh8arFJW3A5vg7Suaggo28ApXVF2EPzkAXbm94ThqaA6r").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"importprivkey\","
                        + "\"params\":[\"L5c6jz6Rh8arFJW3A5vg7Suaggo28ApXVF2EPzkAXbm94ThqaA6r\"],\"id\":1}");
    }

    @Test
    public void testListAddress() throws Exception {
        neow3j.listAddress().send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"listaddress\","
                        + "\"params\":[],\"id\":1}");
    }

    @Test
    public void testSendFrom() throws Exception {
        neow3j.sendFrom(
                "AHE5cLhX5NjGB5R2PcdUvGudUoGUBDeHX4",
                "0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789",
                "AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb",
                "10.0"
        ).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"sendfrom\","
                        + "\"params\":[\"0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789\","
                        + "\"AHE5cLhX5NjGB5R2PcdUvGudUoGUBDeHX4\","
                        + "\"AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb\","
                        + "\"10.0\"],\"id\":1}");
    }

    @Test
    public void testSendFrom_TransactionSendAsset() throws Exception {
        neow3j.sendFrom(
                "AHE5cLhX5NjGB5R2PcdUvGudUoGUBDeHX4",
                new TransactionSendAsset(
                        "0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789",
                        "10.0",
                        "AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb"
                )
        ).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"sendfrom\","
                        + "\"params\":[\"0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789\","
                        + "\"AHE5cLhX5NjGB5R2PcdUvGudUoGUBDeHX4\","
                        + "\"AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb\","
                        + "\"10.0\"],\"id\":1}");
    }

    @Test
    public void testSendMany() throws Exception {
        neow3j.sendMany(
                Arrays.asList(
                        new TransactionSendAsset("0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789", "100", "AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb"),
                        new TransactionSendAsset("0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789", "10", "AHE5cLhX5NjGB5R2PcdUvGudUoGUBDeHX4")
                )
        ).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"sendmany\","
                        + "\"params\":["
                        + "["
                        + "{\"asset\":\"0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789\",\"value\":\"100\",\"address\":\"AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb\"},"
                        + "{\"asset\":\"0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789\",\"value\":\"10\",\"address\":\"AHE5cLhX5NjGB5R2PcdUvGudUoGUBDeHX4\"}"
                        + "]"
                        + "],\"id\":1}");
    }

    @Test
    public void testSendMany_Empty_Transaction() throws Exception {
        neow3j.sendMany(Arrays.asList()).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"sendmany\","
                        + "\"params\":[[]],\"id\":1}");
    }

    @Test
    public void testSendMany_Fee() throws Exception {
        neow3j.sendMany(
                Arrays.asList(
                        new TransactionSendAsset("0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789", "100", "AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb"),
                        new TransactionSendAsset("0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789", "10", "AHE5cLhX5NjGB5R2PcdUvGudUoGUBDeHX4")
                ),
                "50"
        ).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"sendmany\","
                        + "\"params\":["
                        + "["
                        + "{\"asset\":\"0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789\",\"value\":\"100\",\"address\":\"AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb\"},"
                        + "{\"asset\":\"0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789\",\"value\":\"10\",\"address\":\"AHE5cLhX5NjGB5R2PcdUvGudUoGUBDeHX4\"}"
                        + "],"
                        + "\"50\""
                        + "],\"id\":1}");
    }

    @Test
    public void testSendMany_Fee_And_ChangeAddress() throws Exception {
        neow3j.sendMany(
                Arrays.asList(
                        new TransactionSendAsset("0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789", "100", "AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb"),
                        new TransactionSendAsset("0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789", "10", "AHE5cLhX5NjGB5R2PcdUvGudUoGUBDeHX4")
                ),
                "50",
                "AK2nJJpJr6o664CWJKi1QRXjqeic2zRp8y"
        ).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"sendmany\","
                        + "\"params\":["
                        + "["
                        + "{\"asset\":\"0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789\",\"value\":\"100\",\"address\":\"AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb\"},"
                        + "{\"asset\":\"0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789\",\"value\":\"10\",\"address\":\"AHE5cLhX5NjGB5R2PcdUvGudUoGUBDeHX4\"}"
                        + "],"
                        + "\"50\","
                        + "\"AK2nJJpJr6o664CWJKi1QRXjqeic2zRp8y\""
                        + "],\"id\":1}");
    }

    @Test
    public void testSendToAddress() throws Exception {
        neow3j.sendToAddress(
                "0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789",
                "AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb",
                "10.0"
        ).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"sendtoaddress\","
                        + "\"params\":[\"0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789\","
                        + "\"AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb\",\"10.0\"],\"id\":1}");
    }

    @Test
    public void testSendToAddress_TransactionSendAsset() throws Exception {
        neow3j.sendToAddress(
                new TransactionSendAsset("0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789", "10.0", "AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb")
        ).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"sendtoaddress\","
                        + "\"params\":[\"0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789\","
                        + "\"AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb\",\"10.0\"],\"id\":1}");
    }

    @Test
    public void testSendToAddress_Fee() throws Exception {
        neow3j.sendToAddress(
                "0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789",
                "AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb",
                "10.0",
                "0.01"
        ).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"sendtoaddress\","
                        + "\"params\":[\"0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789\","
                        + "\"AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb\","
                        + "\"10.0\","
                        + "\"0.01\"],\"id\":1}");
    }

    @Test
    public void testSendToAddress_TransactionSendAsset_Fee() throws Exception {
        neow3j.sendToAddress(
                new TransactionSendAsset("0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789", "10.0", "AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb"),
                "0.01"
        ).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"sendtoaddress\","
                        + "\"params\":[\"0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789\","
                        + "\"AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb\","
                        + "\"10.0\","
                        + "\"0.01\"],\"id\":1}");
    }

    @Test
    public void testSendToAddress_Fee_And_ChangeAddress() throws Exception {
        neow3j.sendToAddress(
                "0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789",
                "AKYdmtzCD6DtGx16KHzSTKY8ji29sMTbEZ",
                "10.0",
                "0.01",
                "AK2nJJpJr6o664CWJKi1QRXjqeic2zRp8y"
        ).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"sendtoaddress\","
                        + "\"params\":[\"0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789\","
                        + "\"AKYdmtzCD6DtGx16KHzSTKY8ji29sMTbEZ\","
                        + "\"10.0\","
                        + "\"0.01\","
                        + "\"AK2nJJpJr6o664CWJKi1QRXjqeic2zRp8y\"],\"id\":1}");
    }

    @Test
    public void testSendToAddress_TransactionSendAsset_Fee_And_ChangeAddress() throws Exception {
        neow3j.sendToAddress(
                new TransactionSendAsset("0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789", "10.0", "AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb"),
                "0.01",
                "AK2nJJpJr6o664CWJKi1QRXjqeic2zRp8y"
        ).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"sendtoaddress\","
                        + "\"params\":[\"0x9bde8f209c88dd0e7ca3bf0af0f476cdd8207789\","
                        + "\"AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb\","
                        + "\"10.0\","
                        + "\"0.01\","
                        + "\"AK2nJJpJr6o664CWJKi1QRXjqeic2zRp8y\"],\"id\":1}");
    }

    // RpcNep5Tracker

    @Test
    public void testGetNep5Transfers() throws Exception {
        neow3j.getNep5Transfers("AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getnep5transfers\","
                        + "\"params\":[\"AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb\"],\"id\":1}"
        );
    }

    @Test
    public void testGetNep5Transfers_Date() throws Exception {
        neow3j.getNep5Transfers("AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb", new Date(1553105830L)).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getnep5transfers\","
                        + "\"params\":[\"AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb\",1553105830],\"id\":1}"
        );
    }

    @Test
    public void testGetNep5Transfers_DateFromTo() throws Exception {
        neow3j.getNep5Transfers("AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb",
                new Date(1553105830),
                new Date(1557305830)
        ).send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getnep5transfers\","
                        + "\"params\":[\"AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb\",1553105830,1557305830],\"id\":1}"
        );
    }

    @Test
    public void testGetNep5Balances() throws Exception {
        neow3j.getNep5Balances("AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getnep5balances\","
                        + "\"params\":[\"AcozGpiGDpp9Vt9RMyokWNyu7hh341T2bb\"],\"id\":1}"
        );
    }

    // ApplicationLogs

    @Test
    public void testGetApplicationLog() throws Exception {
        neow3j.getApplicationLog("420d1eb458c707d698c6d2ba0f91327918ddb3b7bae2944df070f3f4e579078b").send();

        verifyResult(
                "{\"jsonrpc\":\"2.0\",\"method\":\"getapplicationlog\","
                        + "\"params\":[\"420d1eb458c707d698c6d2ba0f91327918ddb3b7bae2944df070f3f4e579078b\"],\"id\":1}"
        );
    }
}
