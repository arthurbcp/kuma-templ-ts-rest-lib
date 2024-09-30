{{- $data := .Data }}
{{- range $data.Properties -}}
{{- $ref := .Ref -}}
{{- if not $ref  -}}{{- if .Items.Ref -}}{{- $ref = .Items.Ref -}}{{- end -}}{{- end -}}
{{- if $ref -}}
{{- if ne $ref $data.Name  -}}
import { {{ toPascal $ref }} } from './{{ toSnake $ref }}'
{{ end }}
{{- end }}
{{- end }}
{{- if $data.Description }}
// {{ $data.Description }}
{{- end }}
export type {{ toPascal $data.Name }} = { 
    {{- range $data.Properties}}
    {{- if .Description }}
    // {{ .Description }}
    {{- end }}
    {{ .Name }}{{- if not .Required}}?{{- end}}: {{- block "TypeResolver" . }}{{end}}
    {{- end}}
}