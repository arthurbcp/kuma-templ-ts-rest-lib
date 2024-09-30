{{- $data := .Data }}
import { AxiosRequestConfig } from "axios";
import { User } from "../../dto/user";
import HttpProvider from "../../providers/http/http_provider";

export class {{toPascal $data.Name}}Service {
  private provider: HttpProvider;

  constructor(http: HttpProvider) {
    this.provider = http;
  }

{{- range $data.Endpoints}}
  {{- if .Summary }}
  // {{ .Summary }}
  {{- end }}
  public {{.Name}}(data: {
    query: any;
    params: any;
    {{- if .RequestBody }}
    data: {{ (index .RequestBody.Content.MediaTypes 0).Ref }};
    {{- end}}
    config: AxiosRequestConfig;
  }): Promise<AxiosResponse<any>> {
    return this.provider.request<>("/repositories/{id}", data);
  }
}
{{- end}}