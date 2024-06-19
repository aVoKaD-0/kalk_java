p = {"koren":"str", "c":"int", "f":"int", "g":"int", "c2":"int", "f2":"int", "g2":"int", "a":"str", "Drob_Ne":"int", "Drob_V":"int", "number":"double", "number2":"double", "numerator":"str", "number3":"double", "number4":"double", "denominator":"str", "NeKPL":"boolean", "KPL":"boolean", "KDR":"boolean", "NeKDR":"boolean"}
d = ["koren", "c", "f", "g", "c2", "f2", "g2", "a", "Drob_Ne", "Drob_V", "number", "number2", "number3", "number4", "numerator", "denominator", "NeKDR", "KDR", "KPL", "NeKPL"]
s2 = []
with open("java.txt", "r") as file:
    lines = [line.rstrip() for line in file]
with open("java.txt", "w") as file:
    for i in range(len(lines)):
        flag = True
        s1 = 0
        s1_2 = 0
        so = 0
        t = 0
        k = 0
        dlin = len(lines[i])
        while t < dlin:
            # for h in d:
            #     for j in range(t+3, len(lines[i])):
            #         if j + len(h) <= len(lines[i]):
            #             if h == lines[i][j:j+len(h)]:
            #                 n = h
            #                 flag = False
            #                 break
            #         if flag == False:
            #             break
            #     if flag == False:
            #             break
            if lines[i][t:t+3] == "str" and lines[i][t+4] == "(":
                # if p[n] == "double":
                    lines[i] = lines[i][:t] + "String.valueOf" + lines[i][t+3:]
                    # if len(s1) > 0 and s1[0] > t:
                    #     s1[0] += 11
                # if p[n] == "int":
                    lines[i] = lines[i][:t] + "String.valueOf" + lines[i][t+3:]
                    # if len(s1) > 0 and s1[0] > t:
                    #     s1 += 13
            if lines[i][t:t+5] == "float" and lines[i][t+4] == "(":
                # if p[n] == "str":
                    lines[i] = lines[i][:t] + "Double.parseDouble" + lines[i][t+6:]
                    # if len(s1) > 0 and s1[0] > t:
                    #     s1 += 11
                # if p[n] == "int":
                #     lines[i] = lines[i][:t] + "double)" + lines[i][t+6:]
                    # if len(s1) > 0 and s1[0] > t:
                    #     s1 += 2
            if lines[i][t:t+3] == "int" and lines[i][t+4] == "(":
                # if p[n] == "double":
                #     lines[i] = lines[i][:t] + "int)" + lines[i][t+3:]
                    # if len(s1) > 0 and s1[0] > t:
                    #     s1[0] = s1[0] + 2
                # if p[n] == "str":
                    lines[i] = lines[i][:t] + "Integer.parseInt" + lines[i][t+3:]
                    # if len(s1) > 0 and s1[0] > t:
                    #     s1 += 13
            if lines[i][t:t+4] == "find" and lines[i][t+4] == "(":
                lines[i] = lines[i][:t] + "indexOf" + lines[i][t+4:]
                # if len(s1) > 0 and s1[0] > t:
                #     s1 += 3
            
            if lines[i][t:t+5] == "False":
                lines[i] = lines[i][:t] + "false" + lines[i][t+5:]
            if lines[i][t:t+4] == "True":
                lines[i] = lines[i][:t] + "true" + lines[i][t+4:]
            

            if lines[i][t:t+3] == "len" and lines[i][t+3] == "(":
                for j in range(t, len(lines[i])):
                    if lines[i][j] == "(":
                        s1 = j
                        s1_2 += 1
                    if s1_2 == 1 and lines[i][j] == ")":
                        lines[i] = lines[i][:s1-3] + lines[i][s1:j+1] + ".length()" + lines[i][j+1:]
                        s1 = 0
                    if lines[i][j] == ")":
                        s1_2 -= 1

            if lines[i][t:t+3] == "and" and lines[i][t-1] == " ":
                lines[i] = lines[i][:t] + "&&" + lines[i][t+3:]
            if lines[i][t:t+2] == "or" and lines[i][t-1] == " ":
                lines[i] = lines[i][:t] + "||" + lines[i][t+2:]

            print(i, t, s2)

            if len(s2) > 0:
                for j in range(len(s2)-1, -1, -1):
                    if s2[j] == t and lines[i][t] != " ":
                        file.write(" "*(t) + "}" + "\n")
                        s2 = s2[:-1]
            if lines[i][t:t+2] == "if" or lines[i][t:t+4] == "else" or lines[i][t:t+4] == "elif":
                s2.append(t)
                for j in range(len(lines[i])-1, -1, -1):
                    if lines[i][j] == ":":
                        if lines[i][t:t+2] == "if":
                            lines[i] = lines[i][:t+3] + "(" + lines[i][t+3:j] + ") :"
                        break
            if lines[i][t:t+4] == "elif":
                lines[i] = lines[i][:t] + "else if" + lines[i][t+4:]

            # print(i, lines[i][lines[i].find("("):lines[i].find(")")+1])
            
            if lines[i][t:t+3] == "for" and lines[i][t+3] == " ":
                sk = lines[i].find(")")
                for j in range(len(lines[i])-1, -1, -1):
                    if lines[i][j] == ")" and lines[i][j+1] == ":":
                        sk = j
                if lines[i].find(",") != -1:
                    lines[i] = lines[i][:t+3] + " (int " + lines[i][t+4] + " = 0; " + lines[i][t+4] + " <" + lines[i][lines[i].find(",")+1:sk] + "; " + lines[i][t+4] + "++):"
                else:
                    lines[i] = lines[i][:t+3] + " (int " + lines[i][t+4] + " = 0; " + lines[i][t+4] + " < " + lines[i][lines[i].find("(")+1:sk] + "; " + lines[i][t+4] + "++):"
            
            if lines[i][t:t+5] == "round":
                so1 = 0
                sk1 = 0
                sz1 = 0
                for g in range(t, len(lines[i])):
                    if lines[i][g] == "(":
                        so1 += 1
                    if lines[i][g] == ")":
                        so1 -= 1
                    if so1 == 0 and g != t+6 and lines[i][g] == ")":
                        sk1 = g
                        break
                for g in range(sk1, 0, -1):
                    if lines[i][g] == ",":
                        sz1 = g
                        break
                lines[i] = lines[i][:t] + "Double.parseDouble(String.format(String.format('%.' + " + lines[i][sz1+1:sk1] + "'f'), " + lines[i][t+6:sz1] + ")"
                                                            
            if lines[i][t] == "[":
                k = t
            if lines[i][t] == "]" and k != 0:
                if lines[i][k+1] == ":":
                    # print("a")
                    lines[i] = lines[i][:k] + ".substring(0, " + lines[i][k+2:t] + ")" + lines[i][t+1:]
                elif lines[i][t-1] == ":":
                    # print("b")
                    lines[i] = lines[i][:k] + ".substring(" + lines[i][k+1:t-1] + ", )" + lines[i][t+1:]
                elif lines[i][k:t].find(":") > -1:
                    # print("c")
                    lines[i] = lines[i][:k] + ".substring(" + lines[i][k+1:lines[i].find(":")] + ", " + lines[i][lines[i].find(":")+1:t] + ")" + lines[i][t+1:]
                else:
                    # print("d")
                    lines[i] = lines[i][:k] + ".charAt(" + lines[i][k+1:t] + ")" + lines[i][t+1:]
            
            # print(t, dlin, lines[i], lines[i][lines[i].find("("):lines[i].find(")")+1])
            dlin = len(lines[i])
            t += 1
                                                                                                
        if lines[i].find(":") == -1:
            if lines[i].find("#") == -1:
                lines[i] = lines[i] + ";"
            else:
                lines[i] = lines[i][:lines[i].find("#")-2] + "; " + "//" + lines[i][lines[i].find("#")+1:]
        elif lines[i].find(":") != -1:
            # lines[i] = lines[i][:lines[i].find(":")] + " {"
            if lines[i].find("#") == -1:
                lines[i] = lines[i][:lines[i].find(":")] + "{"
            else:
                lines[i] = lines[i][:lines[i].find("#")-2] + "{ " + "//" + lines[i][lines[i].find("#")+1:]


        file.write(lines[i] + "\n")